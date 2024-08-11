package com.example.AppointmentBackend.sms;

import com.example.AppointmentBackend.otp.Otp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
@CrossOrigin
public class SmsController {

    private final SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/sms")
    public ResponseEntity<String> sendSms() {
        try {
            String otp = Otp.generate();
            smsService.sendSms(otp);
            return ResponseEntity.ok(otp);
        } catch(IllegalArgumentException error) {
            return ResponseEntity.badRequest().body(error.getMessage());
        }
    }
}
