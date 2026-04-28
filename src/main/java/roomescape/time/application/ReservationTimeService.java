package roomescape.time.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.time.domain.ReservationTimeRepository;
import roomescape.time.presentation.dto.ReservationTimeRequest;
import roomescape.time.presentation.dto.ReservationTimeResponse;

@Service
@RequiredArgsConstructor
public class ReservationTimeService {

    private final ReservationTimeRepository repository;

    public List<ReservationTimeResponse> getReservationTimes() {
        return repository.findAll()
                .stream()
                .map(ReservationTimeResponse::from)
                .toList();
    }


    public ReservationTimeResponse addReservationTime(ReservationTimeRequest request) {
        return ReservationTimeResponse.from(repository.save(ReservationTimeRequest.toEntity(request)));
    }

    public void deleteReservationTime(Long id) {
        repository.deleteById(id);
    }
}
