package com.mail.sender.controller;

import com.mail.sender.config.AdminConfig;
import com.mail.sender.domain.MailDto;
import com.mail.sender.mapper.EmailMapper;
import com.mail.sender.service.DbService;
import com.mail.sender.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class EmailDbController {

    @Autowired
    private DbService service;

    @Autowired
    private EmailMapper mapper;

    @Autowired
    private SimpleEmailService simpleEmailService;


    @RequestMapping(method = RequestMethod.GET, value = "/emails")
    public List<MailDto> getEmails() {
        return mapper.mapToMailDtoList(service.getAllEmails());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/emails", consumes = APPLICATION_JSON_VALUE)
    public void createEmail(@RequestBody MailDto mailDto) {
        service.saveMail(mapper.mapToMail(mailDto));
        simpleEmailService.send(mapper.mapToMail(mailDto));

    }
}
