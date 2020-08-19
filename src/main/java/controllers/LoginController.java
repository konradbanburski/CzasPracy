package controllers;

import mainApp.Account;
import support.Hash;
import support.SessionUtils;
import support.Sql;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.NamedEvent;
import javax.servlet.http.HttpSession;

@ManagedBean
@NamedEvent
@RequestScoped
@SessionScoped
public class LoginController {


    private String inputLogin = "";
    private String inputPassword = "";
    private String inputName = "";
    private String inputSurname = "";
    private Account account;
    private Hash hash = new Hash();
    private Sql sql = new Sql();

    public String getInputLogin() {
        return inputLogin;
    }

    public void setInputLogin(String inputLogin) {
        this.inputLogin = inputLogin;
    }

    public String getInputPassword() {
        return inputPassword;
    }

    public void setInputPassword(String inputPassword) {
        this.inputPassword = inputPassword;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputSurname() {
        return inputSurname;
    }

    public void setInputSurname(String inputSurname) {
        this.inputSurname = inputSurname;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String authorize()
    {
        account = sql.selectAccount(inputLogin);
        String encodeInputPassword = hash.encodeValue(inputPassword);
        if (encodeInputPassword.equals(account.getPassword())) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", account.getLogin());
            session.setAttribute("id", account.getId());
            if(account.getAccountType()==1) {
                return "panel/adminUserForm.xhtml";
            }
            else {
                return "panel/userForm.xhtml";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                                "Błędny login lub hasło!", ""));
        }
        inputLogin = null;
        inputPassword = null;

        return "login.xhtml";
    }

    public void register()
    {
        String encodePassword = hash.encodeValue(inputPassword);
        if (sql.insertAccount(inputLogin, encodePassword, inputName, inputSurname) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Konto zostało utworzone.", ""));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystąpił błąd podczas tworzenia konta!", ""));
        }
    }
}
