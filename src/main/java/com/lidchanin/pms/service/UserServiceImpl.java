package com.lidchanin.pms.service;

import com.lidchanin.pms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    //user.setPassword(PasswordEncoder.encode(user.getPassword()))
}
