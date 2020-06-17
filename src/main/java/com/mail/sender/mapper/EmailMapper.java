package com.mail.sender.mapper;

import com.mail.sender.domain.Mail;
import com.mail.sender.domain.MailDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmailMapper {

    public List<MailDto> mapToMailDtoList(final List<Mail> mailList) {
        return mailList.stream()
                .map(i -> new MailDto(i.getId(), i.getMailFrom(), i.getMailTo(), i.getSubject(), i.getMessage()))
                .collect(Collectors.toList());
    }

    public MailDto mapToMailDto(final Mail mail) {
        return new MailDto(mail.getId(), mail.getMailFrom(), mail.getMailTo(), mail.getSubject(), mail.getMessage());
    }

    public Mail mapToMail(final MailDto mailDto) {
        return new Mail(mailDto.getId(), mailDto.getMailFrom(), mailDto.getMailTo(), mailDto.getSubject(), mailDto.getMessage());
    }
}
