package org.example.data.repository;

import org.example.data.model.EmailApp;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailAppRepository extends MongoRepository<EmailApp, String> {
    EmailApp findByDomainName(String domainName);
}
