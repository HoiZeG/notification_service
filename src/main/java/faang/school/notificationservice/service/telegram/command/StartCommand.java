package faang.school.notificationservice.service.telegram.command;

import faang.school.notificationservice.client.UserServiceClient;
import faang.school.notificationservice.dto.ContactPreferenceDto;
import faang.school.notificationservice.entity.TelegramProfile;
import faang.school.notificationservice.service.telegram.TelegramProfileService;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.Locale;

@Slf4j
@Component(value = "/start")
public class StartCommand extends Command {

    public StartCommand(MessageSource messageSource,
                        UserServiceClient userServiceClient,
                        TelegramProfileService telegramProfileService,
                        CommandBuilder commandBuilder) {
        super(messageSource, userServiceClient, telegramProfileService, commandBuilder);
    }

    @Override
    public SendMessage sendMessage(long chatId, String userName) {
        log.info("Executing START command for chatId: {} with userName: {}", chatId, userName);
        String message;

        if (telegramProfileService.existsByUserName(userName)) {
            message = messageSource.getMessage("telegram.start.already_registered", null, Locale.getDefault());
            return super.commandBuilder.buildMessage(chatId, message);
        }

        try {
            ContactPreferenceDto contact = userServiceClient.getContactPreference(userName);

            TelegramProfile telegramProfile = createTelegramProfile(chatId, userName, contact);
            telegramProfileService.save(telegramProfile);
            log.info("Telegram profile is saved for the user: {}", userName);

            message = messageSource.getMessage("telegram.start.registered", new String[]{userName}, defaultLocale);
        } catch (FeignException exception) {
            log.error("Error occurred while processing the user {}. Exception: {}", userName, exception.getMessage());
            message = messageSource.getMessage("telegram.start.not_registered_corporationX", null, Locale.getDefault());
        }

        return super.commandBuilder.buildMessage(chatId, message);
    }

    private TelegramProfile createTelegramProfile(long chatId, String userName, ContactPreferenceDto contact) {
        log.info("Creating TelegramProfile with chatId {} userName {}", chatId, userName);
        return TelegramProfile.builder()
                .userId(contact.getUserId())
                .userName(userName)
                .chatId(chatId)
                .build();
    }
}
