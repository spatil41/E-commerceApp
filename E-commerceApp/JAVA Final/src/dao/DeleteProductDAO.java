package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import model.Customer;
import model.Product;

public class DeleteProductDAO extends Connector
{
	public Product createProduct(Product product) {
		Connection connect= null;
		//PreparedStatement statement= null;
		//String query = "INSERT INTO product_NM (productID, productCategory, productBrand, site, unitPrice, quantity ) VALUES (?, ?, ?, ?, ?, ?) ;";
		//use generated keys to automatically generate query
		
		try
		{
			String query = "DELETE from product_NM WHERE productID='"+product.ProdID+"';";
				//use generated keys to automatically generate query
		PreparedStatement statement= connection.prepareStatement(query);
			
            statement.executeUpdate();
            System.out.println("Product deleted successfully");
          
            
        } catch(SQLException e){
        	product = null;
            System.out.println("Error deleting product: " + e);
        }
		
		return product;
	}

}


