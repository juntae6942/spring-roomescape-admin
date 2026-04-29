package roomescape.reservation.domain.exception;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException() {
        super("존재하지 않는 예약ID 입니다.");
    }
}
