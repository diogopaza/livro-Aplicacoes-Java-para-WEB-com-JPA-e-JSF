import java.sql.SQLException;
import java.util.List;

public interface AutomovelDAO {
    void salva(Automovel a);
    List<Automovel> lista() throws SQLException;
}
