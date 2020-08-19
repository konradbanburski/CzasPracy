package controllers;

import mainApp.Client;
import mainApp.Job;
import support.Hash;
import support.Sql;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class AdminJobEditFormController {

    private int id;
    private String name;
    private Job job;
    private Sql sql = new Sql();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void saveJob()
    {

        if (sql.updateJob(id, name)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Zapisano zmiany.", ""));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystąpił błąd podczas zapisu!", ""));
        }

    }
    public void deleteJob()
    {
        if (sql.deleteJob(id)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Czynność usunięta.", ""));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wystąpił błąd podczas usuwania czynności!", ""));
        }
    }

    public String gotoAdminJobEditFormWithParameters(Job job)
    {   this.job = job;
        this.id = job.getId();
        this.name = job.getName();
        return "/panel/adminJobEditForm.xhtml?faces-redirect=true";
    }
}

