package org.example.services.user;

import org.example.data.model.EmailApp;
import org.example.data.repository.EmailAppRepository;
import org.example.data.repository.UserRepository;
import org.example.dtos.request.LoginRequest;
import org.example.dtos.request.RegisterRequest;
import org.example.exception.UserExistException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailAppRepository emailAppRepository;

    @AfterEach
    public void startAllAfterTest() {
        userRepository.deleteAll();
        emailAppRepository.deleteAll();
    }

    @Test
    public void testThatWhenUserRegisterWithRightDetailsUserRepositoryCountIsOne() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("Alfred");
        registerRequest.setLastName("Ikemdinachi");
        registerRequest.setPassword("password");
        registerRequest.setPhoneNumber("09123456798");
        registerRequest.setDomainName("alfred312@gmail.com");
        userService.register(registerRequest);
        assertEquals(1, userRepository.count());
    }

    @Test
    public void testThatWhenUserWithExistingDomainNameCanNotRegister() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("Alfred");
        registerRequest.setLastName("Ikemdinachi");
        registerRequest.setPassword("password");
        registerRequest.setPhoneNumber("09123456798");
        registerRequest.setDomainName("alfred312@gmail.com");
        userService.register(registerRequest);
        assertThrows(UserExistException.class, () -> userService.register(registerRequest));
    }
    @DisplayName("test that when user register can login into account")
    @Test
    public void test(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setFirstName("Alfred");
        registerRequest.setLastName("Ikemdinachi");
        registerRequest.setPassword("password");
        registerRequest.setPhoneNumber("09123456798");
        registerRequest.setDomainName("alfred312@gmail.com");
        userService.register(registerRequest);
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("password");
        loginRequest.setDomainName("alfred312@gmail.com");
        userService.login(loginRequest);
        EmailApp emailApp = emailAppRepository.findByDomainName(loginRequest.getDomainName());
        assertTrue(emailApp.isLogIn());
    }

}