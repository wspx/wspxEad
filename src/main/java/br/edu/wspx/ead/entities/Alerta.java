package br.edu.wspx.ead.entities;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Alerta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlerta;

	private String descricao;
	
	private String titulo;
	
	private Boolean visivel;
	
	private Date vencimento;
	
	
	// GETTERS & SETTERS
	
	public Integer getIdAlerta() {
		return idAlerta;
	}

	public void setIdAlerta(Integer idAlerta) {
		this.idAlerta = idAlerta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Boolean getVisivel() {
		return visivel;
	}

	public void setVisivel(Boolean visivel) {
		this.visivel = visivel;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	
}
