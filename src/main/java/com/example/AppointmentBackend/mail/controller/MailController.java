package com.example.AppointmentBackend.mail.controller;

import com.example.AppointmentBackend.form.repository.FormRepository;
import com.example.AppointmentBackend.mail.service.MailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
@CrossOrigin
public class MailController {
    private final MailService mailService;
    private final FormRepository formRepository;

    @Autowired
    public MailController(MailService mailService, FormRepository formRepository) {
        this.mailService = mailService;
        this.formRepository = formRepository;
    }

    @PostMapping("/send/{mail}")
    public ResponseEntity<String> sendMail(@PathVariable String mail) throws MessagingException {
        mailService.sendMail(mail);
        formRepository.deleteAllRows();
        return ResponseEntity.ok("successfully sent the mail...");
    }
}
