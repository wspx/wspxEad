package br.edu.wspx.ead.entities;

import java.util.List;
import javax.persistence.*;

@Entity
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDisciplina;
	
	private String nome;
	
	@Column(length = 10)
	private String sigla;
	
	@OneToMany
	private List<Tarefa> tarefas;
	
	
	//GETTERS AND SETTERS
	
	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
}
