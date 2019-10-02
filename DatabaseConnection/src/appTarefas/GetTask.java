package appTarefas;

public class GetTask  {
	private int id;
	private String Nome_tarefa;
	private int Nivel_Prioridade;
	private String Descricao_Prioridade;
	private String Responsavel;
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setNome_tarefa(String nome_tarefa) {
		Nome_tarefa = nome_tarefa;
	}
	public void setNivel_Prioridade(int nivel_Prioridade) {
		Nivel_Prioridade = nivel_Prioridade;
	}
	public void setDescricao_Prioridade(String descricao_Prioridade) {
		Descricao_Prioridade = descricao_Prioridade;
	}
	public void setResponsavel(String responsavel) {
		Responsavel = responsavel;
	}
	public int getId() {
		return id;
	}
	public String getNome_tarefa() {
		return Nome_tarefa;
	}
	public int getNivel_Prioridade() {
		return Nivel_Prioridade;
	}
	public String getDescricao_Prioridade() {
		return Descricao_Prioridade;
	}
	public String getResponsavel() {
		return Responsavel;
	}
	
}
