package utils;

import java.sql.Connection;

public class ConnectionDB {
	
public static void main(String[] args) {
		
		Connection c = ConnectionManager.getConnection();
		
		if(c != null) {
			System.out.println("Connection Successful");
		}
		
	}


}
