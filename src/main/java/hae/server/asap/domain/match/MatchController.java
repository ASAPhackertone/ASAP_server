package hae.server.asap.domain.match;

import hae.server.asap.config.BaseException;
import hae.server.asap.config.BaseResponse;
import hae.server.asap.domain.match.dto.ShowApplyReq;
import hae.server.asap.domain.match.dto.ShowApplyRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;

    /**
     *
     * @param  위도 (latitude, x)  경토(longitude,y)
     * @return 조건에 맞는 구인 정보
     **/
    @PostMapping("/apply")
    public BaseResponse<ShowApplyRes> showApply(@RequestBody ShowApplyReq showApplyReq){
        try{


            return new BaseResponse<>();

        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }


    @GetMapping("/push")
    public BaseResponse<String> matchingResult(@RequestParam(name="flag") int flag, @RequestParam(name="title") String title){

        try{
            if(flag==1){
                matchService.matchingComplete(title);
            }
            else if(flag == 0){
                matchService.nextMatching(title);
            }
            return new BaseResponse<>("매칭 성공!");
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

}
