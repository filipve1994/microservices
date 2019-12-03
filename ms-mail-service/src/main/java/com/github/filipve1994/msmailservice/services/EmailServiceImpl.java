package com.github.filipve1994.msmailservice.services;

import com.github.filipve1994.msmailservice.dto.UserDto;
import com.github.filipve1994.msmailservice.models.Mail;
import com.github.filipve1994.msmailservice.repositories.MailRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private MailRepository mailRepository;

    @Override
    public void sendSimpleMessage(UserDto input) {

        Mail newMail = new Mail();
        newMail.setTo(input.getUsername());
        newMail.setSubject("Test Subject");
        newMail.setText("Test text");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(newMail.getTo());
        mailMessage.setSubject(newMail.getSubject());
        mailMessage.setText(newMail.getText());

        mailRepository.save(newMail);

        emailSender.send(mailMessage);

    }
}
