package controllers;

import mainApp.HistoryElement;
import support.SessionUtils;
import support.Sql;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.NamedEvent;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@NamedEvent
@RequestScoped
public class UserHistoryController implements Serializable {


    private List<HistoryElement> historyElements;
    private HttpSession session = SessionUtils.getSession();
    private Sql sql = new Sql();

    @PostConstruct
    public void init() {
        historyElements = sql.selectUserHistory(session.getAttribute("id").toString());
        for(int i=0; i<historyElements.size(); i++)
        {
            System.out.println(historyElements.get(i).toString());
        }
    }

    public List<HistoryElement> getHistoryElements() {
        return historyElements;
    }

    public void setHistoryElements(List<HistoryElement> historyElements) {
        this.historyElements = historyElements;
    }


}
