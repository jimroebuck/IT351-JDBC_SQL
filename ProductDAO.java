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
public class ProductDAO {
   
   private Connection conn;
   
   public ProductDAO(Connection e){
       this.conn = e;
   }
    
    public void create(Product p) throws SQLException{
        
        String sql = "insert into product values(" + p.getId() + ", "
                                                + "'" + p.getName() +"', '" 
                                                + p.getDescription() + "', " 
                                                + p.getPrice() + ")";
        
        System.out.println(sql);
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
    }
    
    public void update(Product p)throws SQLException{
        String sql = "update product set price =" + p.getPrice()+
                ", name = '" + p.getName() + "'" +
                ", description = '" + p.getDescription() + "'" +
                " where id = " + p.getId();
        System.out.println(sql);
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
    }
    
    public void delete (Product p)throws SQLException{
               
        Statement statement = conn.createStatement();       
        statement.executeUpdate("delete from product where id = " + p.getId());
    }
    
    public List<Product> getAll() throws SQLException{
        
        List<Product> products = new ArrayList<Product>();               
        Statement statement = conn.createStatement();
        
        
        ResultSet results = statement.executeQuery("select * from product");        
        while(results.next()){
            int id = results.getInt("id");
            String name = results.getString("name");
            String description = results.getString("description");
            double price = results.getDouble("price");
            Product p = new Product();
            p.setId(id);
            p.setName(name);
            p.setDescription(description);
            p.setPrice(price);
            
            products.add(p);
           
           
        }
         
        
        return products;
        
    }
            
}

