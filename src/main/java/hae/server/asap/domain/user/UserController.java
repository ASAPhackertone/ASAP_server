package hae.server.asap.domain.user;

import hae.server.asap.config.BaseException;
import hae.server.asap.config.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    // TODO : API 명세 참고하여서 로그인와 회원가입 작성..

    @GetMapping("/login")
    public BaseResponse<String> login(){

        try {

            return new BaseResponse<String>("로그인완료!");
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }

    }

    @PostMapping("/join")
    public BaseResponse<String> join(){

        try {

            return new BaseResponse<String>("로그인완료!");
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }

    }


}
