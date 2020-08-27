package org.infostroy.view;

import org.infostroy.models.Student;
import org.infostroy.repo.StudentRepo;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ClassView implements Serializable {

    /**
     * In memory repository
     */
    @Inject
    private StudentRepo studentRepo;
    /**
     * Students from repository
     */
    private List<Student> students;

    @PostConstruct
    public void init() {
        students = studentRepo.findAll();
    }

    public List<Student> getStudents() {
        return students;
    }
}
