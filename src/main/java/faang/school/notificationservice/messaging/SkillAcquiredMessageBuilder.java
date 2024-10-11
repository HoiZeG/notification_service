package faang.school.notificationservice.messaging;

import faang.school.notificationservice.client.UserServiceClient;
import faang.school.notificationservice.event.SkillAcquiredEvent;
import faang.school.notificationservice.model.dto.SkillDto;
import faang.school.notificationservice.model.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class SkillAcquiredMessageBuilder implements MessageBuilder<SkillAcquiredEvent> {
    private final UserServiceClient userServiceClient;
    private final MessageSource messageSource;

    @Override
    public Class<SkillAcquiredEvent> getInstance() {
        return SkillAcquiredEvent.class;
    }

    @Override
    public String buildMessage(SkillAcquiredEvent event, Locale locale) {
        UserDto beneficiaryDto = userServiceClient.getUser(event.getUserId());

        List<SkillDto> skills = userServiceClient.getUserSkills(event.getUserId());

        String skillName = skills.stream()
                .filter(skill -> skill.getId() == event.getSkillId())
                .map(SkillDto::getTitle)
                .findFirst()
                .orElse("Unknown Skill");

        return messageSource.getMessage("skill_acquired",
                new Object[]{beneficiaryDto.getUsername(), skillName}, locale);
    }
}
