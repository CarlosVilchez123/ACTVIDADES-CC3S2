package org.example;

public interface MailServer {
    void sendEmail(String recipient, String subject, String text);
}
