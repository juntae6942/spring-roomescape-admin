package roomescape.time.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.time.LocalTime;
import roomescape.time.domain.ReservationTime;

public record ReservationTimeRequest(
        @NotBlank
        @Pattern(regexp = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$", message = "시간 형식은 HH:mm 이어야 합니다.")
        LocalTime startAt
) {
    public static ReservationTime toEntity(ReservationTimeRequest request) {
        return ReservationTime.builder()
                .startAt(request.startAt)
                .build();
    }
}
