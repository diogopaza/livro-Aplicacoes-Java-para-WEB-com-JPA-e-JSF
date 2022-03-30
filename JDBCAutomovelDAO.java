import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBCAutomovelDAO
 */
public class JDBCAutomovelDAO implements AutomovelDAO {
    private Connection connection;
    public JDBCAutomovelDAO() throws Exception{
        this.connection = new ConnectionFactoryJDBC().getConnection(); 
    }
    public void salva(Automovel a){
        String sql = "insert into automoveis(anoFabricacao, anoModelo," + 
                        "marca, modelo, observacoes) values(?,?,?,?,?)";        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, 2020);
            stmt.setInt(2, 2021);
            stmt.setString(3, "Chevrolet");
            stmt.setString(4, "Cobalt");
            stmt.setString(5, "carro");

            stmt.execute();
            stmt.close();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {            
            e.printStackTrace();
        }
    }

    public List<Automovel> lista() throws SQLException{
        String sql = "select * from automoveis";
        List<Automovel> automoveis = new ArrayList<Automovel>(); 
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Automovel automovel = new Automovel();
                automovel.setId(rs.getLong("id"));
                automovel.setAnoFabricacao(rs.getInt("anoFabricacao"));
                automovel.setAnoModelo(rs.getInt("anoModelo"));
                automovel.setMarca(rs.getString("marca"));
                automovel.setModelo(rs.getString("modelo"));
                automovel.setObservacoes(rs.getString("observacoes"));
    
                automoveis.add(automovel);
            }           
       }catch(SQLException e){
           throw new SQLException(e);
       }       
       
        return automoveis;        
    }

    
    
}