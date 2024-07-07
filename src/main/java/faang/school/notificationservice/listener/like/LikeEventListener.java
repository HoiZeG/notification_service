package faang.school.notificationservice.listener.like;

import com.fasterxml.jackson.databind.ObjectMapper;
import faang.school.notificationservice.client.UserServiceClient;
import faang.school.notificationservice.event.LikeEvent;
import faang.school.notificationservice.listener.AbstractEventListener;
import faang.school.notificationservice.messaging.MessageBuilder;
import faang.school.notificationservice.service.NotificationService;
import lombok.NonNull;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class LikeEventListener extends AbstractEventListener<LikeEvent> implements MessageListener {

    public LikeEventListener(ObjectMapper objectMapper,
                             MessageBuilder<LikeEvent> messageBuilder,
                             List<NotificationService> notificationServices,
                             UserServiceClient userServiceClient) {
        super(objectMapper, messageBuilder, notificationServices, userServiceClient);
    }

    @Override
    public void onMessage(@NonNull Message message, byte[] pattern) {
        handleEvent(message, LikeEvent.class, event -> {
            String text = getMessage(event, Locale.getDefault());
            sendNotification(event.getAuthorId(), text);
        });
    }
}
