package roomescape.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roomescape.domain.ReservationRepository;
import roomescape.presentation.dto.ReservationRequest;
import roomescape.presentation.dto.ReservationResponse;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository repository;
    
    public List<ReservationResponse> getReservations() {
        return repository.findAll()
                .stream()
                .map(ReservationResponse::from)
                .toList();
    }

    public ReservationResponse addReservation(ReservationRequest request) {
        return ReservationResponse.from(repository.save(ReservationRequest.toEntity(request)));
    }

    public void cancelReservation(Long id) {
        repository.deleteById(id);
    }
}
