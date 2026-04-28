package roomescape.presentation.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import roomescape.domain.Reservation;

public record ReservationRequest(
        String name,
        LocalDate date,
        LocalTime time
) {
    public static Reservation toEntity(ReservationRequest request) {
        return Reservation.builder()
                .name(request.name)
                .date(request.date)
                .time(request.time)
                .build();
    }
}
