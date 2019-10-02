package appTarefas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NewConections {
	private String usuario = "root";
	private String senha = "root";
	private static NewConections instance;
	
	private NewConections() {}
	
	public static NewConections getInstance() {
		if(instance == null) {
			instance = new NewConections();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app_tarefa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
					usuario, 
					senha);
			
			return conn;
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
}
//Gado demais