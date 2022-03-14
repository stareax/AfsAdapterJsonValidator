package com.example.afsadapterjsonvalidator.DTO.response;

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
public class ResponseDataDTO implements Serializable {
    Integer responseCd;
    String responseDscr;
    Date responseDt;
}
