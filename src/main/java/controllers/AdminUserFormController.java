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
public class AdminUserFormController {
    private String login = "";
    private String password = "";
    private String name = "";
    private String surname = "";
    private String department = "";
    private int accountType;
    private Hash hash = new Hash();
    private Sql sql = new Sql();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public void addUser()
    {
        String encodePassword = hash.encodeValue(password);
        if (sql.insertAccount(login, encodePassword, name, surname, department, accountType) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Użytkownik został utworzony.", ""));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystąpił błąd podczas tworzenia użytkownika!", ""));
        }
    }
}
