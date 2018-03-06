package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.time.LocalDate;

import model.Customer;


public class CustomerRegistrationDAO extends Connector
{
	public Customer create(Customer customer) {
		String query = "INSERT INTO customerRegistration_nm1 (FirstName, LastName, email, password,confirmpass, DOB,UserName ) VALUES (?, ?, ?, ?, ?, ?, ?) ;";
		//use generated keys to automatically generate query
		
		try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
		{
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPassword());
            statement.setString(5, customer.getConfirmPass());
            statement.setDate(6, (Date) customer.getDOB());
            statement.setString(7, customer.getUserName());
            statement.executeUpdate();
           
        } catch(SQLException e){
        	customer = null;
            System.out.println("Error Creating customer: " + e);
        }
		return customer;
	}
	
public static boolean CheckUsernameExists(String username){
	boolean usernameExists = false;
	String query = "SELECT * FROM customerRegistration_nm1 order by UserName desc;";
	try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
		ResultSet r1 = statement.executeQuery();
		String searchUser;
		if(r1.next()){
			searchUser = r1.getString("UserName");
			if(searchUser==username)
			{
				usernameExists = true;
				System.out.println("Username already exists.");
			}
		}
	}catch(SQLException e){
   
            System.out.println("Error Creating customer: " + e);
        }
	return usernameExists;

	}
}

