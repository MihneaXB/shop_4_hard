package com.createq.web_shop.service.impl;

import com.createq.web_shop.dto.UserDTO;
import com.createq.web_shop.model.UserModel;
import com.createq.web_shop.repository.RoleRepository;
import com.createq.web_shop.repository.UserRepository;
import com.createq.web_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class DefaultUserService implements UserService {
    private final DataSource dataSource;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DefaultUserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, DataSource dataSource) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
    }

    @Override
    public void registerNewUser(UserDTO userDTO) {
        System.out.println(">> Register User: " + userDTO.getUsername());
        if(userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Utilizatorul deja exista!");
        }
        UserModel userModel = new UserModel();
        userModel.setUsername(userDTO.getUsername());
        userModel.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userModel.setEnabled(true);
        userModel.getRole().add(roleRepository.findByName("user"));
        userRepository.save(userModel);
    }

    @Override
    public List<UserModel> getAll(){
        return userRepository.findAll();
    }

    @Override
    public void createNewUser(String Username, String Password, String Role) {
        UserModel userModel = new UserModel();
        userModel.setUsername(Username);
        userModel.setPassword(passwordEncoder.encode(Password));
        userModel.setEnabled(true);
        userModel.getRole().add(roleRepository.findByName(Role));
        userRepository.save(userModel);
    }

    @Override
    public void deleteUser(Long id) {
        String deleteRolesSQL = "DELETE FROM user_roles WHERE user_id = ?";
        String deleteUsersSQL = "DELETE FROM users WHERE id = ?";

        try(Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            try (
                 PreparedStatement deleteRolesStmt = conn.prepareStatement(deleteRolesSQL);
                 PreparedStatement deleteUserStmt = conn.prepareStatement(deleteUsersSQL)
            ) {

                deleteRolesStmt.setLong(1, id);
                deleteRolesStmt.executeUpdate();

                deleteUserStmt.setLong(1, id);
                deleteUserStmt.executeUpdate();
                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public UserModel findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
