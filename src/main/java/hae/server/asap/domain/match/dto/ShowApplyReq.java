package hae.server.asap.domain.match.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class ShowApplyReq {

    private final double latitude;
    private final double longitude;

}
