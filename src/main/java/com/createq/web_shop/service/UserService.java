package com.createq.web_shop.service;

import com.createq.web_shop.dto.UserDTO;
import com.createq.web_shop.model.UserModel;

import java.util.List;

public interface UserService {
    void registerNewUser(UserDTO userDTO);
    List<UserModel> getAll();
    void createNewUser(String Username, String Password, String Role);
    void deleteUser(Long id);
    UserModel findByUsername(String username);
}
