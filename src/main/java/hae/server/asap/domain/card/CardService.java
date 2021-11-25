package hae.server.asap.domain.card;

import hae.server.asap.config.BaseException;
import hae.server.asap.config.BaseResponseStatus;
import hae.server.asap.domain.card.dto.CreateAnnouncementReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static hae.server.asap.config.BaseResponseStatus.DATABASE_ERROR;

@RequiredArgsConstructor
@Service
public class CardService {

    private final CardDao cardDao;

    public void createAnnouncement(CreateAnnouncementReq createAnnouncementReq) throws BaseException{

        try{

            cardDao.createAnnouncement(createAnnouncementReq);

        }catch (Exception e){
            throw new BaseException(DATABASE_ERROR);
        }

    }
}
