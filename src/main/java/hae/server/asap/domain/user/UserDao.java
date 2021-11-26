package hae.server.asap.domain.user;

import hae.server.asap.util.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import hae.server.asap.domain.user.dto.CreateUserReq;

@RequiredArgsConstructor
@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public void createUser(CreateUserReq createUserReq){

        String token = JwtService.createJwt(createUserReq.getName());

        String createUserQuery = "INSERT INTO User(token, name, email, password, phoneNumber) values(? ?,?,?,?)";

        Object[] createUserQueryParam = new Object[]{
                token,
                createUserReq.getName(),
                createUserReq.getEmail(),
                createUserReq.getPassword(),
                createUserReq.getPhoneNumber()};

        this.jdbcTemplate.update(createUserQuery, createUserQueryParam);
    }
}
