package com.maiia.pro.DTO;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AppointmentDTO {
    private Integer id;
    private Integer patientId;
    private Integer practitionerId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}