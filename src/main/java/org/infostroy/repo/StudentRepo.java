package org.infostroy.repo;

import org.infostroy.models.Student;

import java.util.List;


/**
 * In memory repository
 */
public interface StudentRepo {
    /**
     * @return list of students in memory
     */
    List<Student> findAll();

    /**
     * @param student student that will be saved to repository
     */
    void save(Student student);

    /**
     * @param student student that will be deleted from repository
     */
    void delete(Student student);

    /**
     * @param name name of student
     * @return boolean value of existing user by his name
     */
    boolean isExist(String name);
}
