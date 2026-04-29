package roomescape.time.domain.validator;

import java.time.LocalTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import roomescape.time.application.ReservationTimeService;
import roomescape.time.domain.exception.ReservationTimeNotFoundException;
import roomescape.time.presentation.dto.ReservationTimeRequest;
import roomescape.time.presentation.dto.ReservationTimeResponse;

@Transactional
@SpringBootTest
class ReservationTimeValidatorTest {

    @Autowired
    private ReservationTimeValidator validator;

    @Autowired
    private ReservationTimeService timeService;


    @Test
    @DisplayName("입력받은 ID에 해당하는 시간이 없으면 예외를 던진다.")
    void validateTestHasNotTime() {
        Assertions.assertThatThrownBy(() -> validator.validateDeletable(1L))
                .isInstanceOf(ReservationTimeNotFoundException.class);
    }

    @Test
    @DisplayName("입력받은 ID에 해당하는 시간이 있으면 통과한다.")
    void validateTestHasTime() {
        ReservationTimeResponse response = timeService.addReservationTime(
                new ReservationTimeRequest(LocalTime.of(10, 0)));
        Assertions.assertThatCode(() -> validator.validateDeletable(response.id()))
                .doesNotThrowAnyException();
    }
}
