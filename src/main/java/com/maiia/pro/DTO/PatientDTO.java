package com.maiia.pro.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}