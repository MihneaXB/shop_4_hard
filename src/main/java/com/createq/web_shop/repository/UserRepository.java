package com.createq.web_shop.repository;

import com.createq.web_shop.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository  extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByUsername(String username);

    Optional<UserModel> findById(Long Id);
}
