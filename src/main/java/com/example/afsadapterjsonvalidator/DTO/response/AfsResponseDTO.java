package com.example.afsadapterjsonvalidator.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AfsResponseDTO implements Serializable {
    Integer responseCd;
    String responseDscr;
    Date responseDt;
    ApplicationDataDTO applicationData;
    List<ResultDataDTO> resultData;
}
