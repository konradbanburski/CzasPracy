package controllers;


import support.Sql;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.NamedEvent;

@ManagedBean
@NamedEvent
@RequestScoped
@SessionScoped
public class AdminJobFormController {
    private String name = "";
    private Sql sql = new Sql();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addJob()
    {
        if (sql.insertJob(name) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Klient został utworzony.", ""));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystąpił błąd podczas tworzenia klienta!", ""));
        }
    }
}
