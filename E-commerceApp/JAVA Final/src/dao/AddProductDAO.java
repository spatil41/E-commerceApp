package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import model.Customer;
import model.Product;

public class AddProductDAO extends Connector
{
	public Product createProduct(Product product) {
		Connection connect= null;
		//PreparedStatement statement= null;
		//String query = "INSERT INTO product_NM (productID, productCategory, productBrand, site, unitPrice, quantity ) VALUES (?, ?, ?, ?, ?, ?) ;";
		//use generated keys to automatically generate query
		
		try
		{
			String query = "INSERT INTO product_NM (productID, productCatagory, productBrand, site, unitPrice, quantity, size ) VALUES (?, ?, ?, ?, ?, ?, ?) ;";
				//use generated keys to automatically generate query
		PreparedStatement statement= connection.prepareStatement(query);
			//System.out.println(product.getProdCategory());
            statement.setInt(1, product.getProdID());
            //System.out.println(product.getProdID());
            statement.setString(2, product.getProdCategory());	
            statement.setString(3, product.getProdBrand());
            statement.setString(4, product.getSite());
            statement.setDouble(5, product.getUnitPrice());
            statement.setInt(6, product.getQuantity());
            statement.setString(7, product.getSize());
            statement.executeUpdate();
            System.out.println("Product added successfully");
           /* ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
            	product.setProdID(resultSet.getInt(1));
            }*/
            
        } catch(SQLException e){
        	product = null;
            System.out.println("Error Creating product: " + e);
        }
		
		return product;
	}

}


