package com.example.AppointmentBackend.form;

import lombok.*;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity // makes it available for Java ORM
@AllArgsConstructor
@NoArgsConstructor
@Data // create getters & setters
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String fullName;

    @NonNull
    private String emailAddress;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String preferredDate;

    @NonNull
    private String preferredTime;

    @NonNull
    private String appointmentReason;
}
