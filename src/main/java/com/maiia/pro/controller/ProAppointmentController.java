package com.maiia.pro.controller;

import com.maiia.pro.DTO.AppointmentDTO;
import com.maiia.pro.entity.Appointment;
import com.maiia.pro.service.ProAppointmentService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/appointments", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProAppointmentController {
    @Autowired
    private ProAppointmentService proAppointmentService;

    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation(value = "Get appointments by practitionerId")
    @GetMapping("/{practitionerId}")
    public List<AppointmentDTO> getAppointmentsByPractitioner(@PathVariable final String practitionerId) {
        return proAppointmentService.findByPractitionerId(practitionerId).stream().map(appointment -> modelMapper.map(appointment, AppointmentDTO.class))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Get all appointments")
    @GetMapping
    public List<AppointmentDTO> getAppointments() {
        return proAppointmentService.findAll().stream().map(appointment -> modelMapper.map(appointment, AppointmentDTO.class))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "save appointment")
    @PostMapping
    public ResponseEntity create(@RequestBody AppointmentDTO appointmentDTO){

        // convert DTO to entity
        Appointment appointmentRequest = modelMapper.map(appointmentDTO, Appointment.class);
        proAppointmentService.saveAppointment(appointmentRequest);

        // convert entity to DTO
        AppointmentDTO appointmentResponse = modelMapper.map(appointmentRequest, AppointmentDTO.class);

        return ResponseEntity.ok(appointmentResponse);
    }

}