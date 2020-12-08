package br.edu.wspx.ead.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.wspx.ead.entities.Aluno;
import br.edu.wspx.ead.services.AlunoService;
import br.edu.wspx.ead.repositories.AlunoRepository;


@Service
public class AlunoServiceImplementation implements AlunoService{
	
	@Autowired
	private AlunoRepository repository;
	
	
	
	@Override
	public Page<Aluno> getAllAlunos(Integer pagina, Integer qtdItens) {
		
		Pageable pages = PageRequest.of(pagina, qtdItens);
		Page<Aluno> allAlunos = repository.findAll(pages);
		
		return allAlunos;
	}

	@Override
	public Aluno consultarAlunoById(Integer idAluno) {
		
		try {
			return repository.findById(idAluno).get();
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public Aluno cadastrarAluno(Aluno novoAluno) {
		novoAluno = repository.save(novoAluno);
		return novoAluno;
	}

	@Override
	public Aluno alterarAluno(Aluno alterarAluno) {
		return repository.save(alterarAluno);
	}

	@Override
	public void excluirAluno(Integer idAluno) {
		repository.deleteById(idAluno);
	}
}
