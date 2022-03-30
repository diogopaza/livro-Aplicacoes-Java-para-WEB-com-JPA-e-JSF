import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Teste {
    public static void main(String[] args) throws Exception {
        //conecta com o banco
        //Connection connection = new ConnectionFactoryJDBC().getConnection();
        //System.out.println("Conexao aberta");
        //connection.close();
        Automovel a = new Automovel();
        JDBCAutomovelDAO automevelDAO = new JDBCAutomovelDAO();
        List<Automovel> automoveis = automevelDAO.lista();
        for (Automovel automovel : automoveis) {
            System.out.println(automovel.getModelo());
        }

    }
}
