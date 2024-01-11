package org.example.services.emailApp;

import org.example.data.model.EmailApp;
import org.example.data.repository.EmailAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailAppServiceImpl implements EmailAppService{
    @Autowired
    private EmailAppRepository emailAppRepository;
    @Override
    public void create(String domainName, String userId) {
        EmailApp emailApp = new EmailApp();
        emailApp.setDomainName(domainName);
        emailApp.setUserId(userId);
        emailAppRepository.save(emailApp);
    }
    @Override
    public EmailApp findEmailApp(String domainName) {
        return emailAppRepository.findByDomainName(domainName);
    }
    @Override
    public void save(EmailApp emailApp) {
        emailAppRepository.save(emailApp);
    }
}
