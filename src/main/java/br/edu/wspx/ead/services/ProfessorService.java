package br.edu.wspx.ead.services;

import br.edu.wspx.ead.entities.Professor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ProfessorService {

	Page<Professor> getAllProfessores(Integer pagina, Integer qtdItens);
	Professor consultarProfessorById(Integer idProfessor);
	Professor cadastrarProfessor(Professor novoProfessor);
	Professor alterarProfessor(Professor alterarProfessor);
	void excluirProfessor(Integer idProfessor);
}
