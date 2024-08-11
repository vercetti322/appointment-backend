package com.example.AppointmentBackend.sms;

import com.example.AppointmentBackend.form.FormRepository;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class SmsService {
    private static final Logger logger = LoggerFactory.getLogger(SmsService.class);

    private final TwilioConfig twilioConfig;

    private final FormRepository formRepository;

    @Autowired
    public SmsService(TwilioConfig twilioConfig, FormRepository formRepository) {
        this.twilioConfig = twilioConfig;
        this.formRepository = formRepository;
    }

    public void sendSms(String otp) {
        Sms sms = new Sms();
        sms.setPhoneNumber(formRepository.findFirstRowPhoneNumber());
        sms.setMessage("Hey \uD83D\uDC4B, "
                + formRepository.findFirstRowFullName()
                + ". Thanks for registering with BeKind \uD83D\uDC9A, here is your otp : "
                + otp
        );
        if (isPhoneNumberValid(sms.getPhoneNumber())) {
            PhoneNumber recipient = new PhoneNumber(sms.getPhoneNumber());
            PhoneNumber sender = new PhoneNumber(twilioConfig.getTrialNumber());
            String message = sms.getMessage();
            MessageCreator creator = Message.creator(recipient, sender, message);
            creator.create(); // sends the message
            logger.info("Sent the sms....");
        } else {
            throw new IllegalArgumentException(
                    "Phone no. [" + sms.getPhoneNumber() + "] is not a valid phone number!"
            );
        }
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return true;
    }
}
