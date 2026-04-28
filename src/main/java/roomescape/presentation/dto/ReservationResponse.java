package roomescape.presentation.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Builder;
import roomescape.domain.Reservation;

@Builder
public record ReservationResponse(
        Long id,
        String name,
        LocalDate date,
        LocalTime time
) {
    public static ReservationResponse from(Reservation reservation) {
        return ReservationResponse.builder()
                .id(reservation.getId())
                .name(reservation.getName())
                .date(reservation.getDate())
                .time(reservation.getTime())
                .build();
    }
}
