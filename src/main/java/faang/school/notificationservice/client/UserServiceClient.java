package faang.school.notificationservice.client;

import faang.school.notificationservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${user-service.host}:${user-service.port}")
public interface UserServiceClient {

    @GetMapping("${url.version}/users/{userId}")
    UserDto getUser(@PathVariable("userId") long userId);

    @GetMapping("${url.version}/users/authorize/{userEmail}/{userPassword}")
    Long authorizeUser(@PathVariable("userEmail") String userEmail, @PathVariable("userPassword") String userPassword);
}
