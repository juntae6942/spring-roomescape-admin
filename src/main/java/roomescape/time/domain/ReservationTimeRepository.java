package roomescape.time.domain;

import java.util.List;
import java.util.Optional;
import roomescape.reservation.domain.exception.ReservationNotFoundException;

public interface ReservationTimeRepository {
    ReservationTime save(ReservationTime reservationTime);
    List<ReservationTime> findAll();
    Optional<ReservationTime> findById(Long id);
    void deleteById(Long id);
    boolean existsById(Long id);

    default ReservationTime getById(Long id) {
        return findById(id).orElseThrow(ReservationNotFoundException::new);
    }
}
