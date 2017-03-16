package com.lidchanin.pms.repository;

import com.lidchanin.pms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface <code>UserRepository</code> provides a wide range of
 * possibilities for work with <code>User</code> objects.
 * And in't extends <code>JpaRepository</code> witch provides standard
 * methods for working with the database.
 *
 * @see org.springframework.data.repository.Repository
 * <p>
 * Annotation <code>Repository</code> indicates that an annotated class
 * is a "Repository".
 * @see Repository
 * @see JpaRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query(value = "SELECT u FROM User u WHERE LOWER(u.ssoId) = LOWER(?1)")
    /**
     * Method <code>findUserBySsoId</code> find user with current username.
     * @param ssoId unique username
     * @return User with required username
     */
    User findUserBySsoId(String ssoId);
}
