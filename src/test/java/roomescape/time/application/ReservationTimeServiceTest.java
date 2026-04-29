package roomescape.time.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import roomescape.time.domain.exception.ReservationTimeNotFoundException;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class ReservationTimeServiceTest {

    @Autowired
    private ReservationTimeService service;

    @Test
    @DisplayName("존재하지 않는 시간ID를 입력하면 예외를 던진다.")
    void wrongReservationTimeId() {
        Assertions.assertThatThrownBy(() -> service.deleteReservationTime(1L))
                .isInstanceOf(ReservationTimeNotFoundException.class);
    }
}
