package appTarefas;

public class Tarefas {
	private int id;
	private String nomeTarefa;
	private int tarefaStatus;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeTarefa() {
		return nomeTarefa;
	}
	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}
	public int getTarefaStatus() {
		return tarefaStatus;
	}
	public void setTarefaStatus(int tarefaStatus) {
		this.tarefaStatus = tarefaStatus;
	}
}
