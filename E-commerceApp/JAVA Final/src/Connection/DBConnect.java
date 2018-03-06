package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author me
 */

public class DBConnect { 

	//Connection object
	private static Connection connection;
	//Database connection parameters
    private static String url = "jdbc:mysql://www.papademas.net:3306/510labs";
    private static String username = "db510";
    private static String password = "510";

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
}