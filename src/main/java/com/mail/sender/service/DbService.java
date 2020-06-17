package com.mail.sender.service;

import com.mail.sender.domain.Mail;
import com.mail.sender.domain.MailNotFoundException;
import com.mail.sender.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {

    @Autowired
    private EmailRepository repository;

    public List<Mail> getAllEmails() {
        return repository.findAll();
    }

    public Mail getMailById(final Long mailId) throws MailNotFoundException {
        return repository.findById(mailId).orElseThrow(MailNotFoundException::new);
    }

    public Mail saveMail(final Mail mail) {
        return repository.save(mail);
    }
}
