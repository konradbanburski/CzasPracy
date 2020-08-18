package controllers;

import mainApp.Account;
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
public class AdminUserListController {

    private Account selectedAccount;
    private List<Account> accounts;
    private HttpSession session = SessionUtils.getSession();
    private Sql sql = new Sql();

    @PostConstruct
    public void init() {
        accounts = sql.selectAccounts();
        for(int i=0; i<accounts.size(); i++)
        {
            System.out.println(accounts.get(i).toString());
        }
    }

    public Account getSelectedAccount() {
        return selectedAccount;
    }

    public void setSelectedAccount(Account selectedAccount) {
        this.selectedAccount = selectedAccount;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public int param()
    {
        return selectedAccount.getId();
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
