package roomescape.time.domain;

import java.time.LocalTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ReservationTime {
    @Setter
    private Long id;
    private LocalTime startAt;
}
