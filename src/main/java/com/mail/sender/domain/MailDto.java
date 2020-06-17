package com.mail.sender.domain;


public class MailDto {
    private Long id;
    private String mailFrom;
    private String mailTo;
    private String subject;
    private String message;

    public MailDto(Long id, String mailFrom, String mailTo, String subject, String message) {
        this.id = id;
        this.mailFrom = mailFrom;
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
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
