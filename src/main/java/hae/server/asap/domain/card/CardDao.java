package hae.server.asap.domain.card;

import hae.server.asap.domain.card.dto.CreateAnnouncementReq;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CardDao {

    private final JdbcTemplate jdbcTemplate;

    // TODO: Announce card 와 job card 모두 생성되어야함
    public void createAnnouncement(CreateAnnouncementReq createAnnouncementReq) {


    }
}
