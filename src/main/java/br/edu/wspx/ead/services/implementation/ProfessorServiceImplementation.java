package br.edu.wspx.ead.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.wspx.ead.entities.Professor;
import br.edu.wspx.ead.services.ProfessorService;
import br.edu.wspx.ead.repositories.ProfessorRepository;


@Service
public class ProfessorServiceImplementation implements ProfessorService{

	@Autowired
	private ProfessorRepository repository;
	
	@Override
	public Page<Professor> getAllProfessores(Integer pagina, Integer qtdItens) {
		
		Pageable pages = PageRequest.of(pagina, qtdItens);
		Page<Professor> allProfessores = repository.findAll(pages);
		
		return allProfessores;
	}

	@Override
	public Professor consultarProfessorById(Integer idProfessor) {
		
		try {
			return repository.findById(idProfessor).get();
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public Professor cadastrarProfessor(Professor novoProfessor) {
		novoProfessor = repository.save(novoProfessor);
		return novoProfessor;
	}

	@Override
	public Professor alterarProfessor(Professor alterarProfessor) {
		return repository.save(alterarProfessor);
	}

	@Override
	public void excluirProfessor(Integer idProfessor) {
		repository.deleteById(idProfessor);
	}

}
