/*
 *Jim Roebuck
 */
package it351.key.assignment.unit.pkg3;

/**
 *
 * @author jimro
 */
public class Customer {
    
    private int id; 
    private String name;
    private String login;
    private String password;

    @Override
    public String toString() {
        return "Customer ID " + id + ": " + name
                + "\n      - Login/Pass = " + login + " / " + password;

    }


    
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
    
    
    
    
    
}
