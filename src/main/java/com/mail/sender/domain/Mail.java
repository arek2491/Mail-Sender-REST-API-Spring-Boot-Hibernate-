package com.mail.sender.domain;

import javax.persistence.*;

@Entity(name = "emails")
public class Mail {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "mailFrom")
    private String mailFrom;

    @Column(name = "mailTo")
    private String mailTo;

    @Column(name = "mailSubject")
    private String subject;

    @Column(name = "message")
    private String message;

    public Mail(Long id, String mailFrom, String mailTo, String subject, String message) {
        this.id = id;
        this.mailFrom = mailFrom;
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
    }

    public Mail() {

    }

    public Long getId() {
        return id;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public String getMailTo() {
        return mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

}
