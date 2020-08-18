package controllers;

import mainApp.Account;
import support.Hash;
import support.Sql;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.NamedEvent;
import java.util.Map;


@ManagedBean
@SessionScoped
public class AdminUserEditFormController {

    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String department;
    private int accountType;
    private Account account;
    private Hash hash = new Hash();
    private Sql sql = new Sql();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void saveUser()
    {
        String encode = hash.encodeValue(password);
        if (sql.updateAccount(id, login, encode, name, surname, department, accountType)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Zapisano zmiany.", ""));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystąpił błąd podczas zapisu!", ""));
        }

    }
    public void deleteUser()
    {
        if (sql.deleteAccount(id)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Konto usunięte.", ""));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystąpił błąd podczas usuwania konta!", ""));
        }
    }

    public String gotoAdminUserEditFormWithParameters(Account account)
    {   this.account = account;
        this.id = account.getId();
        this.login = account.getLogin();
        this.password = account.getPassword();
        this.name =  account.getName();
        this.surname = account.getSurname();
        this.department = account.getDepartment();
        this.accountType = account.getAccountType();
        return "/panel/adminUserEditForm.xhtml?faces-redirect=true";
    }


}

