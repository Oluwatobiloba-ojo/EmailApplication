package org.example.services.user;

import org.example.data.model.EmailApp;
import org.example.data.model.User;
import org.example.data.repository.UserRepository;
import org.example.dtos.request.LoginRequest;
import org.example.dtos.request.RegisterRequest;
import org.example.exception.*;
import org.example.services.emailApp.EmailAppService;
import org.example.util.Mapper;
import org.example.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.example.util.Mapper.mapUser;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailAppService emailAppService;
    @Override
    public void register(RegisterRequest registerRequest) {
        if (emailAppService.findEmailApp(registerRequest.getDomainName()) != null) throw new UserExistException("User already exist");
        User user = Mapper.mapUser(registerRequest);
        userRepository.save(user);
        emailAppService.create(registerRequest.getDomainName(), user.getId());
    }

    @Override
    public void login(LoginRequest loginRequest) {
        EmailApp emailApp = emailAppService.findEmailApp(loginRequest.getDomainName());
        if (emailApp == null) throw new EmailAppException("Invalid login details");
        User user = userRepository.findUserById(emailApp.getUserId());
        if (!user.getPassword().equals(loginRequest.getPassword())) throw new InvalidLoginDetails("Invalid login details");
        emailApp.setLogIn(true);
        emailAppService.save(emailApp);
    }

}
