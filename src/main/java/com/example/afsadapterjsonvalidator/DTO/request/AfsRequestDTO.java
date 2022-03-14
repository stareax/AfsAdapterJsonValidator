package com.example.afsadapterjsonvalidator.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AfsRequestDTO implements Serializable {
    ApplicationDataDTO applicationData;
    SearchDataDTO searchData;
}
