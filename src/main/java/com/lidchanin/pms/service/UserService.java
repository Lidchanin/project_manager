package com.lidchanin.pms.service;

import com.lidchanin.pms.model.User;

import java.util.List;

/**
 * Interface <code>UserService</code> represents functions for working
 * with the database.
 */
public interface UserService {
    /**
     * Method <code>findUserById</code> find user with needed id.
     * @param id unique identification for user.
     * @return User with required id.
     */
    User findUserById(long id);

    /**
     * Method <code>findUserBySsoId</code> find user with needed username.
     * @param ssoId unique username.
     * @return User with required username.
     */
    User findUserBySsoId(String ssoId);

    /**
     * Method <code>saveUser</code> save User in database.
     * @param user which need to save.
     */
    void saveUser(User user);

    /**
     * Method <code>deleteUser</code> delete User in database.
     * @param user which need to delete.
     */
    void deleteUser(User user);

    /**
     * Method <code>deleteUserById</code> delete User with needed id in
     * database.
     * @param id unique identification of User.
     */
    void deleteUserById(long id);

    /**
     * Method <code>getAllUsers</code> receive all users from the database.
     * @see User
     * @return all users.
     */
    List<User> getAllUsers();

    /**
     * Method <code>getAllUsersJSON</code> receive all user tasks from
     * the database and convert them to JSON String format.
     * @return all users in JSON String format.
     */
    String getAllUsersJSON();

}
