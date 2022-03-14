package com.example.afsadapterjsonvalidator.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchDataDTO implements Serializable {
    List<TaxDTO> tax;
    List<PersonDTO> person;
    List<DocDTO> doc;
    List<PhoneDTO> phone;
}
