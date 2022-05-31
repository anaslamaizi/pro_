package com.maiia.pro.controller;

import com.maiia.pro.DTO.AppointmentDTO;
import com.maiia.pro.DTO.AvailabilityDTO;
import com.maiia.pro.entity.Availability;
import com.maiia.pro.service.ProAvailabilityService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/availabilities", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProAvailabilityController {
    @Autowired
    private ProAvailabilityService proAvailabilityService;

    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation(value = "Get availabilities by practitionerId")
    @GetMapping
    public List<AvailabilityDTO> getAvailabilities(@RequestParam final Integer practitionerId) {
        return proAvailabilityService.findByPractitionerId(practitionerId).stream().map(availability -> modelMapper.map(availability, AvailabilityDTO.class))
                .collect(Collectors.toList());
    }
}