package controllers;


import support.Hash;
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
public class AdminClientFormController {
    private String name = "";
    private String shortName = "";
    private Sql sql = new Sql();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void addClient()
    {
        if (sql.insertClient(name, shortName) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Klient został utworzony.", ""));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystąpił błąd podczas tworzenia klienta!", ""));
        }
    }
}
