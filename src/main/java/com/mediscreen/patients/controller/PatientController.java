package com.mediscreen.patients.controller;

import com.mediscreen.patients.model.Patient;
import com.mediscreen.patients.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @Operation(summary = "Validate a patient object", responses = {
            @ApiResponse(responseCode = "200", description = "Validation successful"),
            @ApiResponse(responseCode = "404", description = "Not found / An error occurred")})
    @PostMapping("/patient/validate")
    public void validate(@RequestBody @Valid Patient patient, BindingResult result) {
        if (!result.hasErrors()) {
            patientService.addPatient(patient);
        }
    }

    @Operation(summary = "Get a patient by id", responses = {
            @ApiResponse(responseCode = "200", description = "Patient successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The patient was not found")})
    @GetMapping("/patient/getPatientById/{id}")
    public Optional<Patient> getPatientById(@PathVariable Integer id) {
        return patientService.getPatientById(id);
    }

    @Operation(summary = "Patients list", responses = {
            @ApiResponse(responseCode = "200", description = "Patients list successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found - The patients list was not found")})
    @GetMapping("/patient/list")
    public Iterable<Patient> list() {
        return patientService.getAllPatients();
    }

    @Operation(summary = "Update a patient", responses = {
            @ApiResponse(responseCode = "200", description = "Update successful"),
            @ApiResponse(responseCode = "404", description = "Not found / An error occurred")})
    @PostMapping("/patient/updatePatient")
    public void updatePatient(@RequestBody @Valid Patient patient) {
            patientService.updatePatient(patient);
    }

    @Operation(summary = "Delete a patient", responses = {
            @ApiResponse(responseCode = "200", description = "Deletion successful"),
            @ApiResponse(responseCode = "404", description = "Not found / An error occurred")})
    @GetMapping("/patient/delete/{id}")
    public void deleteBid(@PathVariable("id") Integer id) {
        patientService.deletePatientById(id);
    }
}
