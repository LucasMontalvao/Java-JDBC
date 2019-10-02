package appTarefas;
import java.sql.Connection;

public abstract class BaseDao {
	public Connection getConnection() {
		return NewConections.getInstance().getConnection();
	}
}
