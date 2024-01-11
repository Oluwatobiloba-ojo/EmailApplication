package org.example.services.emailApp;

import org.example.data.model.EmailApp;

public interface EmailAppService {
    void create(String domainName, String userId);

    EmailApp findEmailApp(String domainName);

    void save(EmailApp emailApp);
}
