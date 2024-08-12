package com.example.AppointmentBackend.sms.config;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@ConfigurationProperties("twilio")
public class TwilioConfig {
    private final static Logger logger = LoggerFactory.getLogger(TwilioConfig.class);

    private String accountSID;
    private String authToken;
    private String trialNumber;

    @PostConstruct
    public void initTwilio() {
        Twilio.init(accountSID, authToken);
        logger.info("Twilio initialised...");
    }
}


