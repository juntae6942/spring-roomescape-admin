package roomescape.reservation.presentation.dto;

import java.time.LocalDate;
import roomescape.reservation.domain.Reservation;
import roomescape.time.domain.ReservationTime;

public record ReservationRequest(
        String name,
        LocalDate date,
        Long timeId
) {
    public static Reservation toEntity(ReservationRequest request, ReservationTime time) {
        return Reservation.builder()
                .name(request.name)
                .date(request.date)
                .time(time)
                .build();
    }
}
