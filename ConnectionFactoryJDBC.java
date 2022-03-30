import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryJDBC {
    public Connection getConnection() throws Exception{
        try{
            return DriverManager.getConnection(
                "jdbc:mysql://localhost/pentestweb", "root", "password");
        }catch(SQLException e){
            throw new SQLException("Erro ao conectar com banco" , e);
        }
    }
}
