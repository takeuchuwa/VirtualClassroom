package org.infostroy.storage;

import org.infostroy.models.Student;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton in memory storage
 */
@ApplicationScoped
public class StudentStorage {

    private final static StudentStorage storage;

    List<Student> students;

    static {
        storage = new StudentStorage();
    }

    private StudentStorage() {
        students = new ArrayList<>();
    }

    public List<Student> students() {
        return students;
    }

    public static StudentStorage storage() {
        return storage;
    }
}
