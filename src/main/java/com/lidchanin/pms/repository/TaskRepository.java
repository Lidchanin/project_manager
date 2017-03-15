package com.lidchanin.pms.repository;

import com.lidchanin.pms.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface <code>TaskRepository</code> provides a wide range of
 * possibilities for work with <code>Task</code> objects.
 * And in't extends <code>JpaRepository</code> witch provides standard
 * methods for working with the database
 * @see org.springframework.data.repository.Repository
 *
 * Annotation <code>Repository</code> indicates that an annotated class
 * is a "Repository"
 * @see Repository
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
