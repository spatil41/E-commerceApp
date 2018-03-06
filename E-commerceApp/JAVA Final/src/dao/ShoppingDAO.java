package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import model.Customer;
import model.Product;
import model.Shopping;

public class ShoppingDAO extends Connector
{
	public Shopping DisplayShopping(Shopping shopping)
	{
		Connection connect= null;
		try
		{
			
			
			String query="SELECT * FROM product_NM WHERE productCatagory='"+shopping.getPc1()+"' "; 
			//String query = "UPDATE product_NM SET unitPrice= '"+product.unitPrice+"', quantity='"+product.quantity+"' WHERE productID='"+product.ProdID+"';";
				//use generated keys to automatically generate query
		PreparedStatement statement= connection.prepareStatement(query);
		//statement.setDouble(1, product.getUnitPrice());
        //statement.setInt(2, product.getQuantity());
        statement.executeUpdate();
        System.out.println("Product updated successfully");
		
		}catch(SQLException e){
        	shopping = null;
            System.out.println("Error updating product: " + e);
        }
		return shopping;
	}
	
	
	
	
	
	
	
}
