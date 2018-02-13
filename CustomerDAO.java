/*
 *Jim Roebuck
 */
package it351.key.assignment.unit.pkg3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jimro
 */
public class CustomerDAO {

    private Connection conn;

    public CustomerDAO(Connection e) {
        this.conn = e;
    }

    public void create(Customer c) throws SQLException {
        String sql = "insert into customer values("
                + c.getId() + ", "
                + "'" + c.getName() + "', '"
                + c.getLogin() + "', '"
                + c.getPassword() + "')";

        System.out.println(sql);
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
    }

    public void update(Customer c) throws SQLException {
        String sql = "update customer set name ='" + c.getName()
                + "', login = '" + c.getLogin() + "'"
                + ", password = '" + c.getPassword() + "'"
                + "where id = " + c.getId();
        System.out.println(sql);
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
    }

    public void delete(Customer c) throws SQLException {
        Statement statement = conn.createStatement();
        statement.executeUpdate("delete from customer where id = " + c.getId());
    }

    public List<Customer> getAll() throws SQLException {
        List<Customer> customers = new ArrayList<Customer>();
        Statement statement = conn.createStatement();

        ResultSet results = statement.executeQuery("select * from customer");
        while (results.next()) {
            int id = results.getInt("id");
            String name = results.getString("name");
            String login = results.getString("login");
            String password = results.getString("password");

            Customer c = new Customer();
            c.setId(id);
            c.setName(name);
            c.setLogin(login);
            c.setPassword(password);

            customers.add(c);                            
        }

        return customers;
    }

}
