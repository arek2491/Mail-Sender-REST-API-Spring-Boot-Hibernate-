package com.mail.sender.domain;

public class InfoMail {

    private String mailTo;
    private String subject;
    private String message;

    public InfoMail(String mailTo, String subject, String message) {
        this.message = message;
        this.subject = subject;
        this.mailTo = mailTo;
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
