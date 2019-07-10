package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Dto.RegistraionDto;

public class RegistrationDao 
{
	public static Connection RegDao( ) throws ClassNotFoundException, SQLException 
	{
		String url = "jdbc:mysql://localhost:3306/RegistrationLogin" ;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,"root","root");
		return con; 
	}

}
