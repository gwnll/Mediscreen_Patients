package com.mediscreen.patients;

import com.mediscreen.patients.model.Patient;
import com.mediscreen.patients.service.PatientService;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PatientServiceTests {

    @Autowired
    PatientService patientService;

    @Test
    public void addPatient() {
        int patientsAmountBefore = IterableUtils.size(patientService.getAllPatients());
        Patient patientTest = new Patient("lastname", "firstname", "01-01-2001");
        patientService.addPatient(patientTest);
        int patientsAmountAfter = IterableUtils.size(patientService.getAllPatients());
        Assertions.assertTrue(patientsAmountBefore < patientsAmountAfter);
    }

    @Test
    public void getPatientById() {
        Optional<Patient> patientTest = patientService.getPatientById(51);
        Assertions.assertTrue(patientTest.isPresent());
    }

    @Test
    public void getAllPatients() {
        Patient patientTest = new Patient("lastname", "firstname", "01-01-2001");
        patientService.addPatient(patientTest);
        List<Patient> allPatients = (List<Patient>) patientService.getAllPatients();
        Assertions.assertTrue(allPatients.contains(patientTest));
    }

    @Test
    public void updatePatient() {
        Patient patientTestBeforeUpdate = patientService.getPatientById(101).orElseThrow(() -> new IllegalArgumentException("Invalid patient Id: 101"));
        String patientTestBeforeUpdateFirstname = patientTestBeforeUpdate.getFirstName();
        patientTestBeforeUpdate.setFirstName("newname");
        patientService.updatePatient(patientTestBeforeUpdate);
        Patient patientTestAfterUpdate = patientService.getPatientById(101).orElseThrow(() -> new IllegalArgumentException("Invalid patient Id: 101"));
        String patientTestAfterUpdateFirstname = patientTestAfterUpdate.getFirstName();
        Assertions.assertNotEquals(patientTestBeforeUpdateFirstname, patientTestAfterUpdateFirstname);
    }

    @Test
    public void deletePatientById() {
        patientService.deletePatientById(1);
        Optional<Patient> patientTest = patientService.getPatientById(1);
        Assertions.assertFalse(patientTest.isPresent());
    }

}
