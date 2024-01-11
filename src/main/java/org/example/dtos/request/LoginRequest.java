package org.example.dtos.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String domainName;
    private String password;
}
