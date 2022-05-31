package com.maiia.pro.controller;

import com.maiia.pro.DTO.PatientDTO;
import com.maiia.pro.DTO.PratictionerDTO;
import com.maiia.pro.entity.Practitioner;
import com.maiia.pro.service.ProPractitionerService;
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
@RequestMapping(value = "/practitioners", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProPractitionerController {
    @Autowired
    private ProPractitionerService proPractitionerService;

    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation(value = "Get practitioners")
    @GetMapping
    public List<PratictionerDTO> getPractitioners() {

        return proPractitionerService.findAll().stream().map(practioner -> modelMapper.map(practioner, PratictionerDTO.class))
                .collect(Collectors.toList());
    }
}