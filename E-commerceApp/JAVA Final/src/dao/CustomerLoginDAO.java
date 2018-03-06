package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Customer;

public class CustomerLoginDAO extends Connector
{
	public Customer findCustomerByName(String UserName){
		Customer customer = null;
		String query = "Select * from customerRegistration_nm1 where UserName = ?;";
		try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, UserName);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
            	customer = new Customer(
            			resultSet.getInt("id"),
            			resultSet.getString("FirstName"),
            			resultSet.getString("LastName"),
            			resultSet.getString("email"),
            			resultSet.getString("password"),
            			resultSet.getString("confirmPass"),
            			resultSet.getDate("DOB"),
            			resultSet.getString("UserName")
            			
            			);
            }
        } catch(SQLException e){
            System.out.println("Error Finding User by Username: " + e);
        }
        return customer;
    }


}
