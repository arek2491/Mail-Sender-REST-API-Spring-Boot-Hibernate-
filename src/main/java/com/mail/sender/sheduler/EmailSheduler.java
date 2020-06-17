package com.mail.sender.sheduler;

import com.mail.sender.config.AdminConfig;
import com.mail.sender.domain.InfoMail;
import com.mail.sender.repository.EmailRepository;
import com.mail.sender.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailSheduler {

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private EmailRepository repository;

    @Scheduled(cron = " * * 10 * * *")
    public void sendInfoMail() {
        long size = repository.count();
        simpleEmailService.sendInfo(new InfoMail(
                adminConfig.getAdminMail(),
                "info mail",
                message(size)
        ));

    }

    private String message(long size) {
        return "In database you have " + size + " emails";
    }
}
