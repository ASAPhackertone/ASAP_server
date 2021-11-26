package hae.server.asap.domain.match;

import hae.server.asap.config.BaseException;
import hae.server.asap.config.BaseResponse;
import hae.server.asap.domain.match.dto.PushReq;
import hae.server.asap.domain.match.dto.ShowApplyReq;
import hae.server.asap.domain.match.dto.ShowApplyRes;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {

    private final MatchService matchService;

    /**
     *
     * 위도  (latitude, x)  경토(longitude,y)
     * @return 조건에 맞는 구인 정보전달
     **/
    @PostMapping("/apply")
    public BaseResponse<ShowApplyRes> showApply(@RequestBody ShowApplyReq showApplyReq){
        try{

            ShowApplyRes showApplyRes = matchService.nextMatching(showApplyReq);
            return new BaseResponse<>(showApplyRes);

        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }


    @PostMapping("/push")
    public BaseResponse<String> matchingResult(@RequestBody PushReq pushReq){

        try{
            if(pushReq.getFlag()==0){
                matchService.matchingComplete(pushReq);
            }
            else if(pushReq.getFlag() == 1){

                matchService.cachedCount(pushReq.getName());
                return new BaseResponse<>("매칭 거절요청 확인됨");
            }
            return new BaseResponse<>("매칭 성공!");
        }catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

}
