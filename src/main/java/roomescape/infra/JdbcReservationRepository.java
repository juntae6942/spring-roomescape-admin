package roomescape.infra;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import roomescape.domain.Reservation;
import roomescape.domain.ReservationRepository;

@Repository
@RequiredArgsConstructor
public class JdbcReservationRepository implements ReservationRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<Reservation> rowMapper = (resultSet, rowNum) -> {
        return Reservation.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .date(resultSet.getDate("date").toLocalDate())
                .time(resultSet.getTime("time").toLocalTime())
                .build();
    };

    @Override
    public Reservation save(Reservation reservation) {
        String sql = "INSERT INTO reservation(name, date, time) "
                + "VALUES(:name, :date, :time)";

        SqlParameterSource params = new BeanPropertySqlParameterSource(reservation);
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(sql, params, keyHolder);
        long generatedId = Objects.requireNonNull(keyHolder.getKey()).longValue();
        reservation.setId(generatedId);
        return reservation;
    }

    @Override
    public List<Reservation> findAll() {
        String sql = "SELECT id, name, date, time FROM reservation";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM reservation WHERE id=:id";
        jdbcTemplate.update(sql, Map.of("id", id));
    }
}
