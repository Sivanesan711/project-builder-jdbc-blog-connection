package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager
{
	public Connection getconnection() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("oracle.jdbc.OracleDriver");
		
		Connection con = null;
		
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Oracle","SYSTEM","root");
		
		if(con!=null)
		{
			System.out.println("Connection Established");
		}
		else
		{
			System.out.println("Check Your Connection");
		}
		
		
		return con;
	}
	
	public static Properties loadPropertiesFile() throws IOException
	{
		Properties prop = new Properties();	
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
}


