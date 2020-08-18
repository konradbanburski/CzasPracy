package controllers;

import mainApp.HistoryElement;
import support.Sql;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.NamedEvent;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


@ManagedBean
@NamedEvent
@ViewScoped
public class AdminClientHistoryController implements Serializable {


    private List<HistoryElement> historyElements;
    private Sql sql = new Sql();
    private String id;
    private String name;
    private String shortName;


    public AdminClientHistoryController()
    {
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        id = params.get("id");
        shortName = params.get("shortName");
        name = params.get("name");
        System.out.println(id + " " + name + " " + shortName + " " + " konstruktor");
    }

    @PostConstruct
    public void init() {
        System.out.println(id + " " + name + " " + shortName + " " + " init");
        historyElements = sql.selectClientHistory(id);
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
