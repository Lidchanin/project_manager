package com.lidchanin.pms.service;

import com.lidchanin.pms.config.mapper.JsonConverter;
import com.lidchanin.pms.model.User;
import com.lidchanin.pms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class <code>UserServiceImpl</code> represents functions for working
 * with the database. And it's implements {@link UserService} for
 * encapsulation.
 *
 * Annotation <code>Service</code> declaring that the class is a
 * service-component of the service-layer.
 * @see Service
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private JsonConverter jsonConverter = new JsonConverter();

    @Override
    public User findUserById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findUserBySsoId(String ssoId) {
        return userRepository.findUserBySsoId(ssoId);
    }

    // todo: ask about a realization of method
    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.delete(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String getAllUsersJSON() {
        return jsonConverter.toJSON(userRepository.findAll());
    }
}
