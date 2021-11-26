package hae.server.asap.domain.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
@Setter
public class CreateUserReq{
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}