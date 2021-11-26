package hae.server.asap.domain.card;

import hae.server.asap.domain.card.dto.CreateAnnouncementReq;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CardDao {

    private final JdbcTemplate jdbcTemplate;

    public void createAnnouncement(CreateAnnouncementReq createAnnouncementReq){

        String getUserIdBynameQuery = "SELECT id FROM user WHERE name = ? ";

        int userId = this.jdbcTemplate.queryForObject(getUserIdBynameQuery,int.class,createAnnouncementReq.getName());


        String createAnnouncementQuery = "INSERT INTO announcecard(u_id,user_name,location,latitude,longitude,payment,title" +
                "category, desc,start_time,end_time) values(?,?,?,?,?,?,?,?,?,?,?)";

        List<String> category = createAnnouncementReq.getCategory();
        Object[] createAnnounceQueryParam = new Object[]{userId,
                createAnnouncementReq.getName(),
                createAnnouncementReq.getLocation(),
                createAnnouncementReq.getLatitude(),
                createAnnouncementReq.getLongitude(),
                createAnnouncementReq.getPayment(),
                createAnnouncementReq.getTitle(),
                category.get(0), //큰 분류
                createAnnouncementReq.getDesc(),
                createAnnouncementReq.getStartTime(),
                createAnnouncementReq.getFinishTime()};

        //생성
        this.jdbcTemplate.update(createAnnouncementQuery,createAnnounceQueryParam);



    }

    private void createJobCard() {


    }
}
