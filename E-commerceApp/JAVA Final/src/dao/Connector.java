package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector implements AutoCloseable {

	protected static Connection connection;
    private static String url = "jdbc:mysql://www.papademas.net:3306/510labs?useSSL=false";
    private static String username = "db510";
    private static String password = "510";
    
    public Connector() {
    	try {
            connection = DriverManager.getConnection(url, username, password);
            
        } catch(SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }
    }
    
 public static Connection connect() throws SQLException{
    	
        connection = DriverManager.getConnection(url,username,password);
        return connection;
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(connection !=null && !connection.isClosed())
            return connection;
        connect();
        return connection;

    }
    
	@Override
	public void close() {
    	try {
            connection.close();
            connection = null;
        } catch(SQLException e) {
            System.out.println("Error closing connection: " + e);
        }
	}
}
