package com.example.AppointmentBackend.mail.service;

import com.example.AppointmentBackend.Utils.FormatDateTime;
import com.example.AppointmentBackend.form.repository.FormRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;
    private final FormRepository formRepository;

    @Autowired
    public MailService(JavaMailSender mailSender, TemplateEngine templateEngine, FormRepository formRepository) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
        this.formRepository = formRepository;
    }

    public void sendMail(String recipient) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(recipient);
        helper.setSubject("BeKind Session Details..");

        // Creating Thymeleaf context and adding variables
        Context context = new Context();
        context.setVariable("date", FormatDateTime.formatDate(formRepository.findLastRowDate()));
        context.setVariable("time", FormatDateTime.formatTime(formRepository.findLastRowTime()));
        context.setVariable("firstName", formRepository.findLastRowFullName());
        System.out.println(formRepository.findLastRowFullName());

        // render html template with variables
        String htmlContent = templateEngine.process("MailTemplate", context);
        helper.setText(htmlContent, true);

        mailSender.send(message);
    }
}
