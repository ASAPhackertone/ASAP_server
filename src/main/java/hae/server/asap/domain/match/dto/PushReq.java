package hae.server.asap.domain.match.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PushReq {

    private final String title;
    private final int flag;
    private final String name;

}
