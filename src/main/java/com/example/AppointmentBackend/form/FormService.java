package com.example.AppointmentBackend.form;

import org.springframework.stereotype.Service;

@Service
public class FormService {

    private final FormRepository formRepository;

    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    public void postFormInfo(Form form) {
        formRepository.save(form);
    }
}
