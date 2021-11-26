package hae.server.asap.domain.match;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MatchService {


    private final MatchDao matchDao;

    /**
     * 해당 공고 매칭 완료 처리
     */
    public void matchingComplete(String title) throws Exception{
        try{

        }catch (Exception e){
            throw e;
        }

    }
    /**
     * 다음공고 보내줌
     * @return 거리 조건 맞는 다음 공고
     */
    public void nextMatching(String title) throws Exception{
        try{

        }catch (Exception e){
            throw e;
        }
    }
}
