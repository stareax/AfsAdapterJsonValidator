package com.example.afsadapterjsonvalidator;

import com.example.afsadapterjsonvalidator.DTO.request.AfsRequestDTO;
import com.example.afsadapterjsonvalidator.DTO.response.AfsResponseDTO;
import com.example.afsadapterjsonvalidator.DTO.response.ApplicationDataDTO;
import com.example.afsadapterjsonvalidator.DTO.response.ResultDataDTO;
import com.example.afsadapterjsonvalidator.DTO.response.RulesDTO;

import javax.interceptor.Interceptors;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.Date;

@Path("/request_afs")
public class AfsService {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AfsResponseDTO sendResponse(AfsRequestDTO afsRequest) {
        System.out.println("AfsService");
        return fillCorrectValues();
    }

    public AfsResponseDTO fillWrongValues() {
        AfsResponseDTO afsResponse = new AfsResponseDTO();
        return afsResponse;
    }

    public AfsResponseDTO fillCorrectValues() {
        AfsResponseDTO afsResponse = new AfsResponseDTO();
        afsResponse.setResponseCd(4);
        afsResponse.setResponseDscr("Внутренняя ошибка сервиса");
        afsResponse.setResponseDt(new Date());

        ApplicationDataDTO applicationData = new ApplicationDataDTO();
        applicationData.setApplicationId("e96b3d0e-66fc-11eb-ae93-0242ac130002");
        applicationData.setApplicationExtId("e1113d0e-66fc-11eb-ae93-0242ac130002");
        applicationData.setQueryGuid("2222d0e-66fc-11eb-ae93-0242ac130002");
        afsResponse.setApplicationData(applicationData);

        ResultDataDTO resultData = new ResultDataDTO();
        resultData.setId(1);
        RulesDTO rules = new RulesDTO();
        rules.setRuleCd("4C_Org_001");
        rules.setRuleGrp("GR3");
        rules.setItemCreateDt(new Date());
        rules.setRuleDscr("ИНН ЮЛ/ИП в списке АФС ФЛ с BL");
        resultData.setRules(Collections.singletonList(rules));
        afsResponse.setResultData(Collections.singletonList(resultData));

        afsResponse.setApplicationData(applicationData);
        return afsResponse;
    }
}
