package roomescape.time.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.time.domain.validator.ReservationTimeValidator;
import roomescape.time.domain.ReservationTimeRepository;
import roomescape.time.presentation.dto.ReservationTimeRequest;
import roomescape.time.presentation.dto.ReservationTimeResponse;

@Service
@RequiredArgsConstructor
public class ReservationTimeService {

    private final ReservationTimeValidator reservationTimeValidator;
    private final ReservationTimeRepository repositoryTimeRepository;

    public List<ReservationTimeResponse> getReservationTimes() {
        return repositoryTimeRepository.findAll()
                .stream()
                .map(ReservationTimeResponse::from)
                .toList();
    }


    public ReservationTimeResponse addReservationTime(ReservationTimeRequest request) {
        return ReservationTimeResponse.from(repositoryTimeRepository.save(ReservationTimeRequest.toEntity(request)));
    }

    public void deleteReservationTime(Long id) {
        reservationTimeValidator.validateDeletable(id);
        repositoryTimeRepository.deleteById(id);
    }
}
