package mainApp;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Account {
    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String department;
    private int accountType;
    private String accountTypeName;

    public Account() { convertAccountTypeToName(); }

    public Account(int id, String login, String password, String name, String surname, String department, int accountType) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.accountType = accountType;
        convertAccountTypeToName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    private void convertAccountTypeToName() {
        switch (accountType) {
            case 0:
                accountTypeName = "Zwykły użytkownik";
                break;
            case 1:
                accountTypeName = "Administrator";
                break;
        }
    }
}
