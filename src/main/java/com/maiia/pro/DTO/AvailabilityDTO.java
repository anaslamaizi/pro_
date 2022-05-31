package com.maiia.pro.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AvailabilityDTO {

    private Integer id;
    private Integer practitionerId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}