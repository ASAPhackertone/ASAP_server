package hae.server.asap.domain.match;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MatchDao {

    private final JdbcTemplate jdbcTemplate;



}
