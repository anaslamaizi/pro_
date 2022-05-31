package com.maiia.pro.controller;

import com.maiia.pro.DTO.AvailabilityDTO;
import com.maiia.pro.DTO.PatientDTO;
import com.maiia.pro.entity.Patient;
import com.maiia.pro.service.ProPatientService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProPatientController {
    @Autowired
    private ProPatientService proPatientService;

    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation(value = "Get patients")
    @GetMapping
    public List<PatientDTO> getPatients() {
        return proPatientService.findAll().stream().map(patient -> modelMapper.map(patient, PatientDTO.class))
                .collect(Collectors.toList());
    }
}