package mainApp;

import java.sql.Time;
import java.util.Date;

public class HistoryElement {

    public HistoryElement(String job, String client, Date date, Time time) {
        this.job = job;
        this.client = client;
        this.date = date;
        this.time = time;
    }

    public HistoryElement(String userLogin, String job, String client, Date date, Time time) {
        this.userLogin = userLogin;
        this.job = job;
        this.client = client;
        this.date = date;
        this.time = time;
    }

    private String userLogin;
    private String job;
    private String client;
    private Date date;
    private Time time;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
