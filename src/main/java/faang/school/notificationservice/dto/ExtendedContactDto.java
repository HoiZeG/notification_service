package faang.school.notificationservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExtendedContactDto {
    @NotNull
    private Long userId;
    private String username;
    private String phone;
    private String tgChatId;
}