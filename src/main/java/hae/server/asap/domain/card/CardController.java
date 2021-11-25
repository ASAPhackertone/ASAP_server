package hae.server.asap.domain.card;

import hae.server.asap.config.BaseException;
import hae.server.asap.config.BaseResponse;
import hae.server.asap.domain.card.dto.CreateAnnouncementReq;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CardController {

    private final CardService cardService;


    /**
     * 공고 만들기
     */
    @PostMapping("/annountment")
    public BaseResponse<String> createAnnouncement(@RequestParam CreateAnnouncementReq createAnnouncementReq){

        try{
            cardService.createAnnouncement(createAnnouncementReq);
            return new BaseResponse<>("공고 생성 성공");
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }

    }

}
