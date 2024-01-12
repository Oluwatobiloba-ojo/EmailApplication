package org.example.service;

import org.example.data.model.EmailApp;
import org.example.dto.request.SendEmailRequest;

public interface EmailAppService {
    String createAccount(String domainName, String id);

    EmailApp findUserDomainName(String domainName);

    String login(String domainName);

    void sendEmail(SendEmailRequest sendEmailRequest);
}
