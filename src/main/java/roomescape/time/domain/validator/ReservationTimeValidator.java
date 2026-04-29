package roomescape.time.domain.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import roomescape.reservation.domain.ReservationRepository;
import roomescape.time.domain.exception.ReservationTimeInUseException;

@Component
@RequiredArgsConstructor
public class ReservationTimeValidator {

    private final ReservationRepository repository;

    public void validateDeletable(Long timeId) {
        if (repository.existsByReservationTime(timeId)) {
            throw new ReservationTimeInUseException("해당 시간에 예약이 존재합니다.");
        }
    }
}
