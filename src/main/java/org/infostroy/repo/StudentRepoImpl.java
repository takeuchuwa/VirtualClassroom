package org.infostroy.repo;

import org.infostroy.models.Student;
import org.infostroy.storage.StudentStorage;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

/**
 * In memory repository implementation
 */
@ApplicationScoped
public class StudentRepoImpl implements StudentRepo {

    @Override
    public List<Student> findAll() {
        return StudentStorage.storage().students();
    }

    @Override
    public void save(Student student) {
        StudentStorage.storage().students().add(student);
    }

    @Override
    public void delete(Student student) {
        StudentStorage.storage().students().remove(student);
    }

    @Override
    public boolean isExist(String name) {
        for (Student student : StudentStorage.storage().students()) {
            if (student.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}
