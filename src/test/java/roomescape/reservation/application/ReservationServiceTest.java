package roomescape.reservation.application;

import java.time.LocalDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import roomescape.reservation.presentation.dto.ReservationRequest;
import roomescape.time.domain.exception.ReservationTimeNotFoundException;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class ReservationServiceTest {

    @Autowired
    ReservationService service;

    @Test
    @DisplayName("예약 생성시 존재하지 않는 시간ID를 입력하면 예외를 던진다.")
    void wrongTimeTest() {
        Assertions.assertThatThrownBy(() -> service.addReservation(
                new ReservationRequest(
                        "브라운",
                        LocalDate.of(2026, 4, 29),
                        1L
                )
            )
        ).isInstanceOf(ReservationTimeNotFoundException.class);
    }
}
