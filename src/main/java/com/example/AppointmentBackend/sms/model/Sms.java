package com.example.AppointmentBackend.sms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sms {

    @NonNull
    private String phoneNumber;

    @NonNull
    private String message; // message body

    @Override
    public String toString() {
        return "SMS {" +
                "phone number = '" + phoneNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
