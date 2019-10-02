package appTarefas;


public class Main {

	public static void main(String[] args) {
		//############################################################
		//Starting OBJ's for transactions with database				
		UsuarioDAO usuarioDAO = new UsuarioDAO();				
		TarefasDAO tarefaDAO = new TarefasDAO();
		PrioridadesDAO prioridadeDAO = new PrioridadesDAO();
		//############################################################
		
		//############################################################
		//Seting some models for operations
		Usuario user = new Usuario();
		user.setNome("Jose");
		user.setSobrenome("da Silva");
		Tarefas tarefa = new Tarefas();
		tarefa.setNomeTarefa("Jantar daqui a 2 horas");
		tarefa.setTarefaStatus(1);
		//Priority model will not be set because this make no sense, 
		//all the data we need is already set in the database by scripts
		//#############################################################
		
		//#############################################################
		//Inserting some data in the database
		usuarioDAO.Insert(user);
		tarefaDAO.insert(tarefa, prioridadeDAO.getById(2).getId(), usuarioDAO.getById(1));
		//#############################################################
		
		//#############################################################
		//Getting some data from the database
		for(Usuario usuario : usuarioDAO.getAll()) {
			System.out.println(usuario.getNome() + " " + usuario.getSobrenome());
		}
		System.out.println();
		System.out.println(usuarioDAO.getById(1).getNome());
		System.out.println();
		System.out.println("|ID|" + "" + "|Descrição da Tarefa     |" + "|NIvel de prioridade|" + " "+ "|Descrição Prioridade|" + "|   Reponsavel  |");
		for(GetTask tarefas : tarefaDAO.getAll()) {
			System.out.println("|" + tarefas.getId() + " ||" + tarefas.getNome_tarefa() + "||         " + tarefas.getNivel_Prioridade() + "         | |        " + tarefas.getDescricao_Prioridade() + "       ||"  + tarefas.getResponsavel() + "|");
		}
		//#############################################################
		
		//#############################################################
		//Updating data in database
		user.setId(usuarioDAO.getById(1).getId());
		user.setNome("Alberto");
		usuarioDAO.update(user);
		tarefa.setId(tarefaDAO.getById(1).getId());
		tarefa.setTarefaStatus(0);
		tarefaDAO.update(tarefa, prioridadeDAO.getById(1).getId(), user);
		//#############################################################
		
		//#############################################################
		//Let's see if the data was updated
		System.out.println();
		for(Usuario usuario : usuarioDAO.getAll()) {
			System.out.println(usuario.getNome() + " " + usuario.getSobrenome());
		}
		System.out.println();
		System.out.println("|ID|" + "" + "|Descrição da Tarefa     |" + "|NIvel de prioridade|" + " "+ "|Descrição Prioridade|" + "|   Reponsavel  |");
		for(GetTask tarefas : tarefaDAO.getAll()) {
			System.out.println("|" + tarefas.getId() + " ||" + tarefas.getNome_tarefa() + "||         " + tarefas.getNivel_Prioridade() + "         | |        " + tarefas.getDescricao_Prioridade() + "       ||"  + tarefas.getResponsavel() + "|");
		}
		//##############################################################
		
		//##############################################################
		//Deleting some data
		tarefaDAO.delete(1);
		//canot delete a user or a property because of the constraint property
		//##############################################################

		//##############################################################
		//Let's see if the data was deleted
		System.out.println();
		for(Usuario usuario : usuarioDAO.getAll()) {
			System.out.println(usuario.getNome() + " " + usuario.getSobrenome());
		}
		System.out.println();
		System.out.println("|ID|" + "" + "|Descrição da Tarefa     |" + "|NIvel de prioridade|" + " "+ "|Descrição Prioridade|" + "|   Reponsavel  |");
		for(GetTask tarefas : tarefaDAO.getAll()) {
			System.out.println("|" + tarefas.getId() + " ||" + tarefas.getNome_tarefa() + "||         " + tarefas.getNivel_Prioridade() + "         | |        " + tarefas.getDescricao_Prioridade() + "       ||"  + tarefas.getResponsavel() + "|");
		}
		//##############################################################
	}

}