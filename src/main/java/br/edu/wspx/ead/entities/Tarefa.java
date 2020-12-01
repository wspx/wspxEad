package br.edu.wspx.ead.entities;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTarefa;
	
	private String titulo;
	
	private String descricao;
	
	private Date disponivel;
	
	private Date vencimento;
	
	private Boolean BloquearTarefa;
	
	
	//GETTERS AND SETTERS
	
	public Integer getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Date disponivel) {
		this.disponivel = disponivel;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Boolean getBloquearTarefa() {
		return BloquearTarefa;
	}

	public void setBloquearTarefa(Boolean bloquearTarefa) {
		BloquearTarefa = bloquearTarefa;
	}
	
}
