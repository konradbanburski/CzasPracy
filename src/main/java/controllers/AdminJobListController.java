package controllers;

import mainApp.Account;
import mainApp.Job;
import support.SessionUtils;
import support.Sql;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.NamedEvent;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@ManagedBean
@NamedEvent
@RequestScoped
public class AdminJobListController {

    private Job selectedJob;
    private List<Job> jobs;
    private Sql sql = new Sql();

    @PostConstruct
    public void init() {
        jobs = sql.selectJobsToObject();
        for(int i=0; i<jobs.size(); i++)
        {
            System.out.println(jobs.get(i).toString());
        }
    }

    public Job getSelectedJob() {
        return selectedJob;
    }

    public void setSelectedJob(Job selectedJob) {
        this.selectedJob = selectedJob;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public String encodeValue(int value) {
        try {
            System.out.println(URLEncoder.encode(Integer.toString(value), StandardCharsets.UTF_8.toString()));
            return URLEncoder.encode(Integer.toString(value), StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }




}
