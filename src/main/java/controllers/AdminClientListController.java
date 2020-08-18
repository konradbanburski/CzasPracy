package controllers;

import mainApp.Account;
import mainApp.Client;
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
public class AdminClientListController {

    private Client selectedClient;
    private List<Client> clients;
    private Sql sql = new Sql();

    @PostConstruct
    public void init() {
        clients = sql.selectClientsToObject();
        for(int i=0; i<clients.size(); i++)
        {
            System.out.println(clients.get(i).toString());
        }
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setAccounts(List<Client> clients) {
        this.clients = clients;
    }

    public int param()
    {
        return selectedClient.getId();
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
