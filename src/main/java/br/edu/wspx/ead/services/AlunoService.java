package br.edu.wspx.ead.services;

import br.edu.wspx.ead.entities.Aluno;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public interface AlunoService {

	Page<Aluno> getAllAlunos(Integer pagina, Integer qtdItens);
	Aluno consultarAlunoById(Integer idAluno);
	Aluno cadastrarAluno(Aluno novoAluno);
	Aluno alterarAluno(Aluno alterarAluno);
	void excluirAluno(Integer idAluno);
}
