package hae.server.asap.domain.user;

import hae.server.asap.config.BaseException;
import hae.server.asap.domain.user.dto.CreateUserReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static hae.server.asap.config.BaseResponseStatus.DATABASE_ERROR;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public void createUser(CreateUserReq createUserReq) throws BaseException{
        try {
            userDao.createUser(createUserReq);
        }catch (Exception e){
            throw new BaseException(DATABASE_ERROR);
        }
    }

}
