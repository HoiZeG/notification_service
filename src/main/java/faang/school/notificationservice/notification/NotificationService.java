package faang.school.notificationservice.notification;

import faang.school.notificationservice.dto.UserDto;

public interface NotificationService {

    UserDto.PreferredContact getPreferredContact();

    void send(UserDto user, String message);
}