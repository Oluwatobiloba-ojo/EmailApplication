package org.example.util;

import org.example.data.model.User;
import org.example.dtos.request.RegisterRequest;

public class Mapper {

    public static User mapUser(RegisterRequest registerRequest){
        User user = new User();
        user.setName(registerRequest.getFirstName() + " " + registerRequest.getLastName());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setPassword(registerRequest.getPassword());
        return user;
    }

}
