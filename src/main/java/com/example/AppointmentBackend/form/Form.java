package com.example.AppointmentBackend.form;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data // create getters & setters
public class Form {
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
