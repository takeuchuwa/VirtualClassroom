package org.infostroy.models;

import org.infostroy.repo.StudentRepo;
import org.jboss.weld.context.RequestContext;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


/**
 * Main model of application
 * @author Dmitry Gorban
 */
@Named
@SessionScoped
public class Student implements Serializable {

    /**
     * Student name
     */
    private String name;
    /**
     * Field that show user hand up or not
     */
    private boolean handUp;

    /**
     * In memory repository
     */
    @Inject
    private StudentRepo studentRepo;

    public Student(){
    }

    public Student(String name) {
        this.name = name;
    }

    /**
     * @return redirection to members page in success login, otherwise notify about fail
     */
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (studentRepo.isExist(name)) {
            return "loginfailed?faces-redirect=true";
        } else {
            studentRepo.save(this);
            context.getExternalContext().getSessionMap().put("user", this);

            return "members?faces-redirect=true";
        }
    }

    /**
     * @return redirection to login page after destruct session
     */
    public String logout() {
        studentRepo.delete(this);
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }

    public void setReverseHandUp() {
        this.handUp = !this.handUp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHandUp() {
        return handUp;
    }

    public void setHandUp(boolean handUp) {
        this.handUp = handUp;
    }
}
