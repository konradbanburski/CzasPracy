package controllers;

import support.SessionUtils;
import support.Sql;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.NamedEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@NamedEvent
@ManagedBean
@RequestScoped
public class UserFormController {

    @PostConstruct
   public void init()
   {
       jobs = sql.selectJobs();
       clients = sql.selectClients();
       this.date = getEndOfDay(new Date());
       //this.time = Time.valueOf("00:00:00");
   }

    private String job;
    private List<SelectItem> jobs;
    private String client;
    private List<SelectItem> clients;
    private Date date;
    private Date time;
    private Sql sql = new Sql();

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<SelectItem> getJobs() {
        return jobs;
    }

    public void setJobs(List<SelectItem> jobs) {
        this.jobs = jobs;
    }

    public String getClient() { return client; }

    public void setClient(String client) { this.client = client; }

    public List<SelectItem> getClients() { return clients; }

    public void setClients(List<SelectItem> clients) { this.clients = clients; }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void addJobToHistory()
    {

        HttpSession session = SessionUtils.getSession();

        if(sql.insertJobToHistory(
                Integer.parseInt(session.getAttribute("id").toString()),
                Integer.parseInt(job),
                Integer.parseInt(client),
                new java.sql.Date(date.getTime()),
                new java.sql.Time (time.getTime())) == true) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Dodano czynność.", ""));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystąpił błąd podczas dodawania czynności", ""));
        }
    }

    private Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year, month, day, 00, 00, 00);
        return calendar.getTime();
    }

    public void showChoose()
    {
        System.out.println(job);
        System.out.println(client);
        System.out.println(date);
        System.out.println(time);
    }
}
