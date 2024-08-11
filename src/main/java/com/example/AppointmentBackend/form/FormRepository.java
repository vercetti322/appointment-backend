package com.example.AppointmentBackend.form;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FormRepository extends JpaRepository<Form, Long> {

    @Query("SELECT f.fullName FROM Form f ORDER BY f.id DESC")
    String findFirstRowFullName();

    @Query("SELECT f.phoneNumber FROM Form f ORDER BY f.id DESC")
    String findFirstRowPhoneNumber();
}
