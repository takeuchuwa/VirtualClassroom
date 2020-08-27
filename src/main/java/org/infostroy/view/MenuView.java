package org.infostroy.view;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class MenuView implements Serializable {

    /**
     * Menuitem value
     */
    private String handAction = "Raise hand up";

    public String getHandAction() {
        return handAction;
    }

    public void setHandAction(String handAction) {
        this.handAction = handAction;
    }

    /**
     * Replace menuitem value
     */
    public void hand() {
        if (handAction.equals("Raise hand up")) {
            handAction = "Raise hand down";
        } else {
            handAction = "Raise hand up";
        }
    }
}
