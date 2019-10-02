package appTarefas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrioridadesDAO extends BaseDao {
	public List<Prioridades> getAll(){
		String sql = "select id, Nivel_prioridade, Descricao_Prioridade from Prioridade";
		List<Prioridades> list = new ArrayList<Prioridades>();
		try {
			try(Connection conn = getConnection(); 
					PreparedStatement p = conn.prepareStatement(sql)){
				ResultSet result = p.executeQuery();
				while(result.next()) {
					Prioridades prioridade = new Prioridades();
					prioridade.setId(result.getInt(1));
					prioridade.setNivelPrioridade(result.getInt(2));
					prioridade.setDescricaoPrioridade(result.getString(3));
					list.add(prioridade);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public Prioridades getById(int id) {
		String sql = "select id, Nivel_prioridade, Descricao_Prioridade from Prioridade where id = ?";
		Prioridades prioridade = null;
		try {
			try(Connection conn = getConnection();
					PreparedStatement p = conn.prepareStatement(sql)){
				p.setInt(1, id);
				ResultSet result = p.executeQuery();
				if(result.next()) {
					prioridade = new Prioridades();
					prioridade.setId(result.getInt(1));
					prioridade.setNivelPrioridade(result.getInt(2));
					prioridade.setDescricaoPrioridade(result.getString(3));
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return prioridade;
	}
}
