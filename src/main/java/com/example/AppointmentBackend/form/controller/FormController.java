package com.example.AppointmentBackend.form.controller;

import com.example.AppointmentBackend.form.service.FormService;
import com.example.AppointmentBackend.form.model.Form;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin
public class FormController {
    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostMapping("/form")
    public ResponseEntity<Map<String, String>> postFormInfo(@RequestBody Form form) {
        formService.postFormInfo(form);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Form submitted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
