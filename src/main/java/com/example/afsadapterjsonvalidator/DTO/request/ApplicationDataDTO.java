package com.example.afsadapterjsonvalidator.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDataDTO implements Serializable {
    String applicationId;
    String applicationExtId;
    String queryGuid;
    Date loanApplicationCreateDateTimeExt;
    Date loanApplicationDateTime;
}
