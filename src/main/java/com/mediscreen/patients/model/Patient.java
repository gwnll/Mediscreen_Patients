package com.mediscreen.patients.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_generator")
    @SequenceGenerator(name = "patient_generator", sequenceName = "patient_id_seq")
    private int id;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "birthdate", nullable = false)
    private String birthdate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    public Patient() {

    }

    public Patient(String lastname, String firstname, String birthdate) {
        this.lastName = lastname;
        this.firstName = firstname;
        this.birthdate = birthdate;
    }
}
