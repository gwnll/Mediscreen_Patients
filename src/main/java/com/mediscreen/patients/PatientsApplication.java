package com.mediscreen.patients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Patients API", version = "1.0", description = "Patients Information"))
public class PatientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsApplication.class, args);
	}

}
