package roomescape.time.presentation.dto;

import java.time.LocalTime;
import roomescape.time.domain.ReservationTime;

public record ReservationTimeRequest(
        LocalTime startAt
) {
    public static ReservationTime toEntity(ReservationTimeRequest request) {
        return ReservationTime.builder()
                .startAt(request.startAt)
                .build();
    }
}
