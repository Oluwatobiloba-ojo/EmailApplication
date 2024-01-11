package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document
public class EmailApp {
    @Id
    private String id;
    private String domainName;
    private List<String> title;
    private boolean isLogIn =false;
    private String userId;
}
