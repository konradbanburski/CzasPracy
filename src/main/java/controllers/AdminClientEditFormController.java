package controllers;

import mainApp.Account;
import mainApp.Client;
import support.Hash;
import support.Sql;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class AdminClientEditFormController {

    private int id;
    private String name;
    private String shortName;
    private Client client;
    private Hash hash = new Hash();
    private Sql sql = new Sql();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void saveClient()
    {

        if (sql.updateClient(id, name, shortName)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Zapisano zmiany.", ""));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystąpił błąd podczas zapisu!", ""));
        }

    }
    public void deleteClient()
    {
        if (sql.deleteClient(id)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Konto usunięte.", ""));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystąpił błąd podczas usuwania konta!", ""));
        }
    }

    public String gotoAdminClientEditFormWithParameters(Client client)
    {   this.client = client;
        this.id = client.getId();
        this.name = client.getName();
        this.shortName = client.getShortName();
        return "/panel/adminClientEditForm.xhtml?faces-redirect=true";
    }


}

