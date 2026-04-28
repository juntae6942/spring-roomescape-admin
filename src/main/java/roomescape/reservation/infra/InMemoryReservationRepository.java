package roomescape.reservation.infra;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import roomescape.reservation.domain.Reservation;
import roomescape.reservation.domain.ReservationRepository;

public class InMemoryReservationRepository implements ReservationRepository {

    private final Map<Long, Reservation> reservations = new ConcurrentHashMap<Long, Reservation>();
    private final AtomicLong index = new AtomicLong(1);

    public Reservation save(Reservation reservation) {
        long sequence = index.getAndIncrement();
        reservation.setId(sequence);
        reservations.put(sequence, reservation);
        return reservation;
    }

    public List<Reservation> findAll() {
        return reservations.values()
                .stream()
                .toList();
    }

    public void deleteById(Long id) {
        reservations.remove(id);
    }
}
