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
public class TaxDTO implements Serializable {
    Integer id;
    String entityId;
    String entityExtId;
    String entityType;
    String tin;
}
