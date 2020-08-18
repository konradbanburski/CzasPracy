package mainApp;

import support.SessionUtils;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.NamedEvent;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@ManagedBean
@NamedEvent
@RequestScoped
@SessionScoped
public class User {

    public String showUserSession()
    {
        HttpSession session = SessionUtils.getSession();
        return "Zalogowany użytkownik: " + session.getAttribute("username").toString();
    }

    public void checkUserSession()
    {
        HttpSession session = SessionUtils.getSession();
        if(session.getAttribute("username")==null) {
            System.out.println("Sesja wygasła");
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            try {
                ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String logout()
    {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "/login.xhtml";
    }

    public String gotoUserForm()
    {
        return "/panel/userForm.xhtml";
    }

    public String gotoUserHistory()
    {
        return "/panel/userHistory.xhtml";
    }

    public String gotoAdminUserForm()
    {
        return "/panel/adminUserForm.xhtml";
    }

    public String gotoAdminUserList()
    {
        return "/panel/adminUserList.xhtml";
    }

    public String gotoAdminClientForm()
    {
        return "/panel/adminClientForm.xhtml";
    }

    public String gotoAdminClientList()
    {
        return "/panel/adminClientList.xhtml";
    }

    public String gotoAdminJobForm()
    {
        return "/panel/adminJobForm.xhtml";
    }

    public String gotoAdminJobList() { return "/panel/adminJobList.xhtml"; }

}
