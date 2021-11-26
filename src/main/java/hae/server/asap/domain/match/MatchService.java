package hae.server.asap.domain.match;

import hae.server.asap.config.BaseException;
import hae.server.asap.domain.match.dto.PushReq;
import hae.server.asap.domain.match.dto.ShowApplyReq;
import hae.server.asap.domain.match.dto.ShowApplyRes;
import hae.server.asap.util.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MatchService {


    private final MatchDao matchDao;

    /**
     * 해당 공고 매칭 완료 처리
     */
    public void matchingComplete(PushReq pushReq) throws BaseException {
        try{
            //해당 공고 체크
            matchDao.completeAnnounceCard(pushReq.getTitle());
            matchDao.cachedInit(pushReq.getName());

        }catch (Exception e){
            throw e;
        }

    }
    /**
     * 다음공고 보내줌
     * @return 거리 조건 맞는 다음 공고
     */
    public ShowApplyRes nextMatching(ShowApplyReq showApplyReq) throws BaseException{
        try{
            int userIdx = matchDao.getUserIdxByName(showApplyReq.getName());
            return matchDao.nextMatching(showApplyReq,userIdx);
        }catch (Exception e){
            throw e;
        }
    }


    /**
     *
     * 유저 이름으로 cached 테이블 증가
     */
    public void cachedCount(String name){
        try{
            matchDao.cachedCount(name);
        }catch (Exception e){
            throw e;
        }

    }

}
