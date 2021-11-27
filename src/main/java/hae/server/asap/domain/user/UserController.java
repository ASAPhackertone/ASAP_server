package hae.server.asap.domain.user;

import hae.server.asap.config.BaseException;
import hae.server.asap.config.BaseResponse;
import hae.server.asap.domain.user.dto.CreateUserReq;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {



    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public BaseResponse<String> login(){

        try {

            return new BaseResponse<String>("로그인완료!");
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }

    }

    @PostMapping("/join")
    public BaseResponse<String> join(@RequestBody CreateUserReq createUserReq){

        try {
            userService.createUser(createUserReq);
            return new BaseResponse<String>("가입완료!");
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }

    }


}
