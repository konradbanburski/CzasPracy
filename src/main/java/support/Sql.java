package support;

import mainApp.Account;
import mainApp.Client;
import mainApp.HistoryElement;
import mainApp.Job;

import javax.faces.model.SelectItem;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sql {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:file:./db";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public boolean insertAccount(String login, String password, String name, String surname)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "insert into ACCOUNTS (LOGIN, PASSWORD, NAME, SURNAME, DEPARTMENT, ACCOUNT_TYPE) values ("+
                    "'" + login + "', " +
                    "'" + password + "', " +
                    "'" + name + "', " +
                    "'" + surname + "', " +
                    "null, 0" +
                    ");";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
            //return true;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
        finally
        {
            //finally block used to close resources
            try{
                if(stmt!=null)
                {
                    stmt.close();
                }
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return true;
    }

    public boolean insertAccount(String login, String password, String name, String surname, String department, int accountType)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "insert into ACCOUNTS (LOGIN, PASSWORD, NAME, SURNAME, DEPARTMENT, ACCOUNT_TYPE) values ("+
                    "'" + login + "', " +
                    "'" + password + "', " +
                    "'" + name + "', " +
                    "'" + surname + "', " +
                    "'" + department + "', " +
                     accountType +
                    ");";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
            //return true;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
        finally
        {
            //finally block used to close resources
            try{
                if(stmt!=null)
                {
                    stmt.close();
                }
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return true;
    }

    public boolean insertJobToHistory(int idAccount, int idJobs, int idClients, Date data, Time time)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "insert into HISTORY (ID_ACCOUNT, ID_JOBS, ID_CLIENT, DATA, TIME) values ("+
                    "'" + idAccount + "', " +
                    "'" + idJobs + "', " +
                    "'" + idClients + "', " +
                    "'" + data + "', " +
                    "'" + time + "'" +
                    ");";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
            //return true;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
        finally
        {
            //finally block used to close resources
            try{
                if(stmt!=null)
                {
                    stmt.close();
                }
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return true;
    }

    public Account selectAccount (String value)
    {
        Account account = new Account();
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "SELECT * from ACCOUNTS WHERE LOGIN like '" + value + "';";
            System.out.println(sql);
            stmt.executeQuery(sql);
            rs = stmt.getResultSet();
            while(rs.next()) {
                account.setId(rs.getInt("ID"));
                account.setLogin(rs.getString("LOGIN"));
                account.setPassword((rs.getString("PASSWORD")));
                account.setName(rs.getString("NAME"));
                account.setSurname(rs.getString("SURNAME"));
                account.setDepartment(rs.getString("DEPARTMENT"));
                account.setAccountType(rs.getInt("ACCOUNT_TYPE"));
            }
            //Clean-up environment
            stmt.close();
            conn.close();
            return account;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try


      return account;
    }

    public Account selectAccount (int value)
    {
        Account account = new Account();
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "SELECT * from ACCOUNTS WHERE ID like '" + value + "';";
            System.out.println(sql);
            stmt.executeQuery(sql);
            rs = stmt.getResultSet();
            while(rs.next()) {
                account.setId(rs.getInt("ID"));
                account.setLogin(rs.getString("LOGIN"));
                account.setPassword((rs.getString("PASSWORD")));
                account.setName(rs.getString("NAME"));
                account.setSurname(rs.getString("SURNAME"));
                account.setDepartment(rs.getString("DEPARTMENT"));
                account.setAccountType(rs.getInt("ACCOUNT_TYPE"));
            }
            //Clean-up environment
            stmt.close();
            conn.close();
            return account;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try


        return account;
    }

    public List selectJobs ()
    {
        List<SelectItem> jobs = new ArrayList<SelectItem>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "SELECT * from JOBS;";
            System.out.println(sql);
            stmt.executeQuery(sql);
            rs = stmt.getResultSet();
            while(rs.next()) {
                jobs.add(new SelectItem(rs.getInt("ID"), rs.getString("NAME")));
            }
            //Clean-up environment
            stmt.close();
            conn.close();
            return jobs;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return jobs;
    }

    public List selectClients()
    {
        List<SelectItem> clients = new ArrayList<SelectItem>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "SELECT * from CLIENTS;";
            System.out.println(sql);
            stmt.executeQuery(sql);
            rs = stmt.getResultSet();
            while(rs.next()) {
                clients.add(new SelectItem(rs.getInt("ID"), rs.getString("NAME")));
            }
            //Clean-up environment
            stmt.close();
            conn.close();
            return clients;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return clients;
    }

    public List selectUserHistory (String userId)
    {
        List<HistoryElement> historyElements = new ArrayList<HistoryElement>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "SELECT ID_ACCOUNT, JOBS.NAME AS JOB, CLIENTS.NAME AS CLIENT, DATA, TIME FROM HISTORY " +
            "LEFT JOIN JOBS ON ID_JOBS=JOBS.ID " +
            "LEFT JOIN CLIENTS ON ID_CLIENT=CLIENTS.ID " +
            "WHERE ID_ACCOUNT LIKE '" + userId + "';";
            System.out.println(sql);
            stmt.executeQuery(sql);
            rs = stmt.getResultSet();
            while(rs.next()) {
                historyElements.add(new HistoryElement(rs.getString("JOB"), rs.getString("CLIENT"), rs.getDate("DATA"), rs.getTime("TIME")));
            }
            //Clean-up environment
            stmt.close();
            conn.close();
            return historyElements;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return historyElements;
    }

    public List selectAccounts ()
    {
        List<Account> users = new ArrayList<Account>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "SELECT * FROM ACCOUNTS";
            System.out.println(sql);
            stmt.executeQuery(sql);
            rs = stmt.getResultSet();
            while(rs.next()) {
                users.add(new Account(rs.getInt("ID"),
                                rs.getString("LOGIN"),
                                rs.getString("PASSWORD"),
                                rs.getString("NAME"),
                                rs.getString("SURNAME"),
                                rs.getString("DEPARTMENT"),
                                rs.getInt("ACCOUNT_TYPE")));
            }
            //Clean-up environment
            stmt.close();
            conn.close();
            return users;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return users;
    }

    public boolean updateAccount(int id, String login, String password, String name, String surname, String department, int accountType)
    {
        System.out.println(id + " " + login + " " +
                password + " " + name + " " + surname + " " + department + " " + accountType);
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "UPDATE ACCOUNTS SET " +
                    "LOGIN ='" + login + "', " +
                    "PASSWORD ='" + password + "', " +
                    "NAME ='" + name + "', " +
                    "SURNAME ='" + surname + "', " +
                    "DEPARTMENT ='" + department + "', " +
                    "ACCOUNT_TYPE ='" + accountType + "' " +
                    "WHERE ID =" + id + ";";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
            //return true;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
        finally
        {
            //finally block used to close resources
            try{
                if(stmt!=null)
                {
                    stmt.close();
                }
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return true;
    }

    public boolean deleteAccount(int id)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "DELETE FROM ACCOUNTS WHERE ID =" + id + ";";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
            //return true;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
        finally
        {
            //finally block used to close resources
            try{
                if(stmt!=null)
                {
                    stmt.close();
                }
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return true;
    }

    public boolean insertClient(String name, String shortName)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "insert into CLIENTS (NAME, SHORT_NAME) values ("+
                    "'" + name + "', " +
                    "'" + shortName + "');";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
            //return true;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
        finally
        {
            //finally block used to close resources
            try{
                if(stmt!=null)
                {
                    stmt.close();
                }
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return true;
    }

    public List selectClientsToObject ()
    {
        List<Client> clients = new ArrayList<Client>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "SELECT * FROM CLIENTS";
            System.out.println(sql);
            stmt.executeQuery(sql);
            rs = stmt.getResultSet();
            while(rs.next()) {
                clients.add(new Client(rs.getInt("ID"),
                        rs.getString("NAME"),
                        rs.getString("SHORT_NAME")));
            }
            //Clean-up environment
            stmt.close();
            conn.close();
            return clients;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return clients;
    }

    public boolean updateClient(int id, String name, String shortName)
    {
        System.out.println(id + " " + name + " " +
                shortName);
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "UPDATE CLIENTS SET " +
                    "NAME ='" + name + "', " +
                    "SHORT_NAME ='" + shortName + "' " +
                    "WHERE ID =" + id + ";";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
            //return true;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
        finally
        {
            //finally block used to close resources
            try{
                if(stmt!=null)
                {
                    stmt.close();
                }
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return true;
    }

    public boolean deleteClient(int id)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "DELETE FROM CLIENTS WHERE ID =" + id + ";";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
            //return true;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
        finally
        {
            //finally block used to close resources
            try{
                if(stmt!=null)
                {
                    stmt.close();
                }
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return true;
    }

    public List selectClientHistory (String clientId)
    {
        List<HistoryElement> historyElements = new ArrayList<HistoryElement>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "SELECT ACCOUNTS.LOGIN AS USER_LOGIN, JOBS.NAME AS JOB, CLIENTS.NAME AS CLIENT, DATA, TIME FROM HISTORY " +
                    "LEFT JOIN ACCOUNTS ON ID_ACCOUNT=ACCOUNTS.ID " +
                    "LEFT JOIN JOBS ON ID_JOBS=JOBS.ID " +
                    "LEFT JOIN CLIENTS ON ID_CLIENT=CLIENTS.ID " +
                    "WHERE ID_CLIENT LIKE '" + clientId + "';";
            System.out.println(sql);
            stmt.executeQuery(sql);
            rs = stmt.getResultSet();
            while(rs.next()) {
                historyElements.add(new HistoryElement(rs.getString("USER_LOGIN"),rs.getString("JOB"), rs.getString("CLIENT"), rs.getDate("DATA"), rs.getTime("TIME")));
            }
            //Clean-up environment
            stmt.close();
            conn.close();
            return historyElements;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return historyElements;
    }

    public boolean insertJob(String name)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "insert into JOBS (NAME) values ("+
                    "'" + name + "');";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
            //return true;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
        finally
        {
            //finally block used to close resources
            try{
                if(stmt!=null)
                {
                    stmt.close();
                }
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return true;
    }

    public List selectJobsToObject ()
    {
        List<Job> jobs = new ArrayList<Job>();
        ResultSet rs = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "SELECT * FROM JOBS";
            System.out.println(sql);
            stmt.executeQuery(sql);
            rs = stmt.getResultSet();
            while(rs.next()) {
                jobs.add(new Job(rs.getInt("ID"),
                        rs.getString("NAME")));
            }
            //Clean-up environment
            stmt.close();
            conn.close();
            return jobs;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return jobs;
    }

    public boolean updateJob(int id, String name)
    {
        System.out.println(id + " " + name);

        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "UPDATE JOBS SET " +
                    "NAME ='" + name + "' " +
                    "WHERE ID =" + id + ";";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
            //return true;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
        finally
        {
            //finally block used to close resources
            try{
                if(stmt!=null)
                {
                    stmt.close();
                }
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return true;
    }

    public boolean deleteJob(int id)
    {
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //Execute a query
            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            String sql =  "DELETE FROM JOBS WHERE ID =" + id + ";";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //Clean-up environment
            stmt.close();
            conn.close();
            //return true;
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        }
        finally
        {
            //finally block used to close resources
            try{
                if(stmt!=null)
                {
                    stmt.close();
                }
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null)
                {
                    conn.close();
                }
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        return true;
    }
}
