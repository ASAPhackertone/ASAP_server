package hae.server.asap.domain.match;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchController {

    /**
     * return 조건에 맞는 구인 정보
     */
    @PostMapping("/apply")

}
