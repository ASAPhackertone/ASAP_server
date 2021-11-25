package hae.server.asap.domain.card.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class CreateAnnouncementReq {
    private String title;
    private String name;
    private int gender;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> category;

    private int payment;
    private String desc;
    private String startTime;
    private String finishTime;
    private String location; // 시 구 동 구분
    private double latitude;
    private double longitude;

    


}
