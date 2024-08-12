package com.example.AppointmentBackend.form.repository;

import com.example.AppointmentBackend.form.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FormRepository extends JpaRepository<Form, Long> {

    @Query("SELECT f.fullName FROM Form f ORDER BY f.id DESC")
    String findLastRowFullName();

    @Query("SELECT f.phoneNumber FROM Form f ORDER BY f.id DESC")
    String findLastRowPhoneNumber();

    @Query("SELECT f.preferredDate FROM Form f ORDER BY f.id DESC")
    String findLastRowDate();

    @Query("SELECT f.preferredTime FROM Form f ORDER BY f.id DESC")
    String findLastRowTime();

    @Modifying
    @Transactional
    @Query("DELETE FROM Form")
    void deleteAllRows();
}
