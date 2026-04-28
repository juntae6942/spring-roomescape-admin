package roomescape.domain;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository {
    Reservation save(Reservation reservation);
    List<Reservation> findAll();
    void deleteById(Long id);
}
