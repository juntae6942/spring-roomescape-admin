package roomescape.reservation.domain.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import roomescape.reservation.domain.ReservationRepository;
import roomescape.reservation.domain.exception.ReservationNotFoundException;

@Component
@RequiredArgsConstructor
public class ReservationValidator {

    private final ReservationRepository repository;

    public void validateDeletable(Long id) {
        if (!repository.existsById(id)) {
            throw new ReservationNotFoundException();
        }
    }
}
