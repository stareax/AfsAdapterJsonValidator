package com.example.afsadapterjsonvalidator;

import com.example.afsadapterjsonvalidator.DTO.request.*;
import com.example.afsadapterjsonvalidator.DTO.response.AfsResponseDTO;
import com.example.afsadapterjsonvalidator.customserializers.JacksonConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.Date;

@Path("/afs_adapter")
@NoArgsConstructor
public class AfsAdapterController {
    @Inject
    @ConfigProperty(name = "url")
    private String url;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AfsResponseDTO request() {
        System.out.println("Start AfsAdapterController");
        String response = ClientBuilder.newClient().target(url).request().post(Entity.entity(fillCorrectValues(), MediaType.APPLICATION_JSON), String.class);
        System.out.println("End AfsAdapterController");
        ObjectMapper mapper = JacksonConfig.createDefaultMapper();
        try {
            AfsResponseDTO afsResponse = mapper.readValue(response, AfsResponseDTO.class);
            System.out.println(afsResponse);
            return afsResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AfsRequestDTO fillCorrectValues() {
        AfsRequestDTO afsRequest = new AfsRequestDTO();
        ApplicationDataDTO applicationData = new ApplicationDataDTO();
        applicationData.setApplicationExtId("e1113d0e-66fc-11eb-ae93-0242ac130002");
        applicationData.setQueryGuid("2222d0e-66fc-11eb-ae93-0242ac130002");
        applicationData.setApplicationId("e96b3d0e-66fc-11eb-ae93-0242ac130002");
        applicationData.setLoanApplicationDateTime(new Date());
        applicationData.setLoanApplicationCreateDateTimeExt(new Date());
        afsRequest.setApplicationData(applicationData);
        SearchDataDTO searchData = new SearchDataDTO();

        DocDTO doc = new DocDTO();
        doc.setDocNumber("123456");
        doc.setDocSeries("1234");
        doc.setEntityExtId("444555668");
        doc.setEntityId("1236");
        doc.setId(3);

        PersonDTO person = new PersonDTO();
        person.setEntityId("1235");
        person.setId(4);
        person.setEntityExtId("444555667");
        person.setBirthDt(new Date());
        person.setLastNm("Иванов");
        person.setFirstNm("Иван");
        person.setPatronNm("Иванович");

        PhoneDTO phone = new PhoneDTO();
        phone.setEntityId("1237");
        phone.setId(2);
        phone.setPhoneType("рабочий");
        phone.setPhoneNumber("8005551111");
        phone.setEntityType("ФЛ");

        TaxDTO tax = new TaxDTO();
        tax.setEntityId("1234");
        tax.setId(1);
        tax.setEntityExtId("444555666");
        tax.setEntityType("ЮЛ");
        tax.setTin("5029069967");

        searchData.setDoc(Collections.singletonList(doc));
        searchData.setPerson(Collections.singletonList(person));
        searchData.setPhone(Collections.singletonList(phone));
        searchData.setTax(Collections.singletonList(tax));

        afsRequest.setSearchData(searchData);

        return afsRequest;
    }
}