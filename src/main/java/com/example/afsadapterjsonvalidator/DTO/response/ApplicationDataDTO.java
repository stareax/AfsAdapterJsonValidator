package com.example.afsadapterjsonvalidator.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDataDTO implements Serializable {
    String applicationId;
    String applicationExtId;
    String QueryGuid;
}
