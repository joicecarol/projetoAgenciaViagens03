package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static final String url = "jdbc:mysql://localhost:3306/agenciaviagensatualizada";
    private static final String user = "root"; 
    private static final String password = "livia";
	
	
    public static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drive encontrado");
         
       
    } catch (ClassNotFoundException e) {
        	 System.out.println("Drive não encontrado! Mensagem: " + e.getMessage());
            
    }

    try {
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("conectado com sucesso");
        return connection;
   
} catch (SQLException e) {
    	 System.out.println("Não foi possivel se conectar ao banco! Mensagem: "+ e.getMessage());
    	
    	 return null;
}
    }
    
}