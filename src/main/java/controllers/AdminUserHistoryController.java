package controllers;

import mainApp.Account;
import mainApp.HistoryElement;
import support.SessionUtils;
import support.Sql;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.NamedEvent;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@ManagedBean
@NamedEvent
@ViewScoped
public class AdminUserHistoryController implements Serializable {


    private List<HistoryElement> historyElements;
    private Sql sql = new Sql();
    private String id;
    private String login;
    private String name;
    private String surname;

    public AdminUserHistoryController()
    {
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        id = params.get("id");
        login = params.get("login");
        name = params.get("name");
        surname = params.get("surname");
        System.out.println(id + " " + login + " " + name + " " + surname + " konstruktor");
    }

    @PostConstruct
    public void init() {
        System.out.println(id + " " + login + " " + name + " " + surname + " init");
        historyElements = sql.selectUserHistory(id);
        for(int i=0; i<historyElements.size(); i++)
        {
            System.out.println(historyElements.get(i).toString());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public List<HistoryElement> getHistoryElements() {
        return historyElements;
    }

    public void setHistoryElements(List<HistoryElement> historyElements) {
        this.historyElements = historyElements;
    }

    /*
    public String gotoAdminUserHistoryWithParameters(Account account)
    {
        this.id = account.getId();
        this.login = account.getLogin();
        this.name = account.getName();
        this.surname = account.getSurname();
        return "/panel/adminUserHistory.xhtml";
    }

     */

}
