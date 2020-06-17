package com.mail.sender.repository;

import com.mail.sender.domain.Mail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmailRepository extends CrudRepository<Mail, Long> {

    @Override
    List<Mail> findAll();

    @Override
    Optional<Mail> findById(Long mailId);

    @Override
    Mail save(Mail mail);

    @Override
    long count();
}
