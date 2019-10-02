package appTarefas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends BaseDao {
	public void Insert(Usuario usuario) {
		String sql = "insert into usuario(nome, sobrenome) values(?, ?)";
		
		try {
			//try with resource
			//fecha automaticamene a conexão e o preparedStatement
			try(Connection conn = getConnection(); 
					PreparedStatement p = conn.prepareStatement(sql)){
				p.setString(1, usuario.getNome());
				p.setString(2, usuario.getSobrenome());	
				p.execute();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void update(Usuario usuario) {
		String sql = "update usuario set nome = ?, sobrenome = ? where id = ?";
		try {
			//try with resource
			//fecha automaticamene a conexão e o preparedStatement
			try(Connection conn = getConnection(); 
					PreparedStatement p = conn.prepareStatement(sql)){
				p.setString(1, usuario.getNome());
				p.setString(2, usuario.getSobrenome());
				p.setInt(3, usuario.getId());
				p.execute();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void delete(int id) {
		String sql = "delete from usuario where id = ?";
		try {
			//try with resource
			//fecha automaticamene a conexão e o preparedStatement
			try(Connection conn = getConnection(); 
					PreparedStatement p = conn.prepareStatement(sql)){
				p.setInt(1, id);
				p.execute();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public Usuario getById(int id) {
		String sql = "select id,nome,sobrenome from usuario where id = ?";
		Usuario usuario = null;
		try {
			//try with resource
			//fecha automaticamene a conexão e o preparedStatement
			try(Connection conn = getConnection(); 
					PreparedStatement p = conn.prepareStatement(sql)){
				p.setInt(1, id);
				
				ResultSet resultSet = p.executeQuery();
				if(resultSet.next()) {
					usuario = new Usuario();
					usuario.setId(resultSet.getInt(1));
					usuario.setNome(resultSet.getString(2));
					usuario.setSobrenome(resultSet.getString(3));
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	public List<Usuario> getAll() {
		String sql = "select id,nome,sobrenome from usuario";
		List<Usuario> list = new ArrayList<Usuario>();
		try {
			//try with resource
			//fecha automaticamene a conexão e o preparedStatement
			try(Connection conn = getConnection(); 
					PreparedStatement p = conn.prepareStatement(sql)){
				
				ResultSet resultSet = p.executeQuery();
				while(resultSet.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(resultSet.getInt(1));
					usuario.setNome(resultSet.getString(2));
					usuario.setSobrenome(resultSet.getString(3));
					
					list.add(usuario);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
