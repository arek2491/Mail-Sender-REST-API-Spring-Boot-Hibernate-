package com.mail.sender.service;

import com.mail.sender.config.AdminConfig;
import com.mail.sender.domain.InfoMail;
import com.mail.sender.domain.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;




@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    AdminConfig adminConfig;

    public void send(final Mail mail) {
        LOGGER.info("Creating mail message...");
        try {
            LOGGER.info("Mail has been send");
            javaMailSender.send(createMailMessage(mail));
        } catch (MailException e) {
            LOGGER.error("Something went wrong: ", e.getMessage(), e);
        }
    }

    public void sendInfo(final InfoMail infoMail) {
        LOGGER.info("Creating mail message...");
        try {
            javaMailSender.send(createInfoMail(infoMail));
            LOGGER.info("Mail has been send");
        } catch (MailException e) {
            LOGGER.error("Something went wrong: ", e.getMessage(), e);
        }
    }

    private SimpleMailMessage createInfoMail(final InfoMail infoMail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(infoMail.getMailTo());
        message.setSubject(infoMail.getSubject());
        message.setText(infoMail.getMessage());

        return message;
    }

    private SimpleMailMessage createMailMessage(final Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.getFrom();
        message.setTo(mail.getMailTo());
        message.setSubject(mail.getSubject());
        message.setText("Mail from: " + mail.getMailFrom() + "\n" + "Subject: " + mail.getSubject() + "\n" + "Message: " + mail.getMessage());

        return message;
    }
}
