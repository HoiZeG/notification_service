package faang.school.notificationservice.builder;

import faang.school.notificationservice.builder.MessageBuilder;
import faang.school.notificationservice.dto.ProfileViewEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;

import java.util.Locale;

@RequiredArgsConstructor
public class ProfileViewMessageBuilder implements MessageBuilder<ProfileViewEvent> {

    private final MessageSource messageSource;

    @Override
    public String buildMessage(ProfileViewEvent eventType, Locale locale) {
        return messageSource.getMessage("profile_view.new", new Object[]{eventType.getProfileViewedId()}, locale);
    }

    @Override
    public boolean supportsEventType(Object eventType) {
        return eventType instanceof ProfileViewEvent;
    }
}
