package roomescape.time.domain;

import java.util.List;

public interface ReservationTimeRepository {
    ReservationTime save(ReservationTime reservationTime);
    List<ReservationTime> findAll();
    ReservationTime findById(Long id);
    void deleteById(Long id);
}
