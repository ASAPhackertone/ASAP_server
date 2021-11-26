package hae.server.asap.domain.match;

import hae.server.asap.domain.match.dto.ShowApplyReq;
import hae.server.asap.domain.match.dto.ShowApplyRes;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class MatchDao {

    private final JdbcTemplate jdbcTemplate;


    //공고 완료 체크
    public void completeAnnounceCard(String title) {

        String completeAnnounceQuery = "UPDATE announcecard SET status = 'MATCHED'  WHERE title = ? ";
        this.jdbcTemplate.update(completeAnnounceQuery,title);

    }


    //카운트초기화
    public void cachedInit(String name){
        String getUserIdBynameQuery = "SELECT id FROM user WHERE name = ? ";
        int userId = this.jdbcTemplate.queryForObject(getUserIdBynameQuery,int.class,name);

        String countInitQuery = "UPDATE cached SET cnt = 0 WHERE u_id = ?";
        this.jdbcTemplate.update(countInitQuery,userId);


    }


    public int getUserIdxByName(String name){
        String getUserIdBynameQuery = "SELECT id FROM user WHERE name = ? ";
        return this.jdbcTemplate.queryForObject(getUserIdBynameQuery,int.class,name);

    }


    /**
     * 다음공고 표시
     * Point(경도,위도) 순으로 넣어야함
     */
    @Transactional
    public ShowApplyRes nextMatching(ShowApplyReq showApplyReq, int userIdx){
        String getCntQuery = "SELECT cnt from cached WHERE id = ? ";   //아이디로 카운트 가져옴
        int count = this.jdbcTemplate.queryForObject(getCntQuery,int.class,userIdx);

        String nextMatchingQuery = "SELECT ST_Distance_Sphere(coordinate,ST_GeomFromText('POINT(? ?)')) as distance " +
                "user_name, location,payment,title,category, desc, start_time, end_time" +
                "FROM announcecard " +
                "ORDER BY distance" +
                " LIMIT ?, 1 ";

        Object[] param = new Object[]{showApplyReq.getLongitude(),showApplyReq.getLatitude(),count};

        return this.jdbcTemplate.queryForObject(nextMatchingQuery,ShowApplyRes.class,param);

    }



    @Transactional
    public void cachedCount(String name){
        String getUserIdBynameQuery = "SELECT id FROM user WHERE name = ? ";
        int userId = this.jdbcTemplate.queryForObject(getUserIdBynameQuery,int.class,name);

        String plusCountQuery = "UPDATE cached SET cnt = cnt + 1 WHERE u_id = ?";
        this.jdbcTemplate.update(plusCountQuery,userId);

    }


}
