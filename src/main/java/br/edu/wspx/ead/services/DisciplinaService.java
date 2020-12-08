package br.edu.wspx.ead.services;

import br.edu.wspx.ead.entities.Disciplina;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public interface DisciplinaService {

	Page<Disciplina> getAllDisciplinas(Integer pagina, Integer qtdItens);
	Disciplina consultarDisciplinaById(Integer idDisciplina);
	Disciplina cadastrarDisciplina(Disciplina novaDisciplina);
	Disciplina alterarDisciplina(Disciplina alterarDisciplina);
	void excluirDisciplina(Integer idDisciplina);
}
