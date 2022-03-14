package com.example.afsadapterjsonvalidator.DTO.response;

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
public class ResultDataDTO implements Serializable {
    Integer id;
    List<RulesDTO> rules;
}
