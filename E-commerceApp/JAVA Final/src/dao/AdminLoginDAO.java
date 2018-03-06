package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Admin;

public class AdminLoginDAO extends Connector {

	public Admin findAdminByUserName(String username){
		Admin admin = null;
		String query = "Select * from adminLogin_NM where username = ?;";
		try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
            	admin = new Admin(
            			resultSet.getInt("id"),
            			resultSet.getString("username"),
            			resultSet.getString("password")
            			);
            }
        } catch(SQLException e){
            System.out.println("Error Finding User by Username: " + e);
        }
        return admin;
    }
}