package roomescape.time.presentation.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import roomescape.time.domain.exception.ReservationTimeInUseException;
import roomescape.time.common.exception.ReservationNotFoundException;

@RestControllerAdvice
public class ReservationTimeExceptionHandler {

    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<String> handleReservationNotFoundException(ReservationNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ReservationTimeInUseException.class)
    public ResponseEntity<String> handleReservationTimeInUseException(ReservationTimeInUseException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
