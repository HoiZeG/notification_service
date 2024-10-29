# В данном микросервисе разработал:

1) RedisConfig настройка для слушателей событий: https://github.com/HoiZeG/notification_service/blob/phoenix-master-stream6/src/main/java/faang/school/notificationservice/config/redis/RedisConfig.java
2) MessageSourceConfig настройка для MessageBuilder: https://github.com/HoiZeG/notification_service/blob/phoenix-master-stream6/src/main/java/faang/school/notificationservice/config/messages/MessageSourceConfig.java
3) TelegramBotConfig содержит токен и название бота: https://github.com/HoiZeG/notification_service/blob/phoenix-master-stream6/src/main/java/faang/school/notificationservice/config/telegram/TelegramBotConfig.java
4) LikeEventListener слушатель событий связаных с лайками: https://github.com/HoiZeG/notification_service/blob/phoenix-master-stream6/src/main/java/faang/school/notificationservice/listener/LikeEventListener.java
5) EventStartEventListener слушатель событий связанных с началом ивента: https://github.com/HoiZeG/notification_service/blob/phoenix-master-stream6/src/main/java/faang/school/notificationservice/listener/EventStartEventListener.java
6) FollowEventListener слушатель событий связанных с новым подписчиком: https://github.com/HoiZeG/notification_service/blob/phoenix-master-stream6/src/main/java/faang/school/notificationservice/listener/FollowEventListener.java
7) TelegramService содержит бизнес-логику по отправке уведомлений в телеграмм: https://github.com/HoiZeG/notification_service/blob/phoenix-master-stream6/src/main/java/faang/school/notificationservice/service/telegram/TelegramService.java
8) Telegram package Bot + Command настройка самого бота + настройка базовых команд: https://github.com/HoiZeG/notification_service/tree/phoenix-master-stream6/src/main/java/faang/school/notificationservice/telegram
