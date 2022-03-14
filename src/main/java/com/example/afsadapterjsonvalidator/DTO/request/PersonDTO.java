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
public class PersonDTO implements Serializable {
    Integer id;
    String entityId;
    String entityExtId;
    String lastNm;
    String firstNm;
    String patronNm;
    Date birthDt;
}
