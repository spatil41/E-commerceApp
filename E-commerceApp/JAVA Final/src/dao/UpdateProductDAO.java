package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import model.Customer;
import model.Product;

public class UpdateProductDAO extends Connector
{
	public Product UpdateProduct(Product product)
	{
		Connection connect= null;
		try
		{
			String query = "UPDATE product_NM SET unitPrice= '"+product.unitPrice+"', quantity='"+product.quantity+"' WHERE productID='"+product.ProdID+"';";
				//use generated keys to automatically generate query
		PreparedStatement statement= connection.prepareStatement(query);
		//statement.setDouble(1, product.getUnitPrice());
        //statement.setInt(2, product.getQuantity());
        statement.executeUpdate();
        System.out.println("Product updated successfully");
		
		}catch(SQLException e){
        	product = null;
            System.out.println("Error updating product: " + e);
        }
		return product;
	}
}
		//PreparedStatement statement= null;