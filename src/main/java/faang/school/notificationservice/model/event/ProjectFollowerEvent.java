package faang.school.notificationservice.model.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectFollowerEvent {
    private Long followerId;
    private Long projectId;
    private Long creatorId;
}