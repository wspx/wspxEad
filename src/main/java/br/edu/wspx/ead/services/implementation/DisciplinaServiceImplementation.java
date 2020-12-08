package br.edu.wspx.ead.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.wspx.ead.entities.Disciplina;
import br.edu.wspx.ead.services.DisciplinaService;
import br.edu.wspx.ead.repositories.DisciplinaRepository;


@Service
public class DisciplinaServiceImplementation implements DisciplinaService{

	@Autowired
	private DisciplinaRepository repository;
	
	
	@Override
	public Page<Disciplina> getAllDisciplinas(Integer pagina, Integer qtdItens) {
		
		Pageable pages = PageRequest.of(pagina, qtdItens);
		Page<Disciplina> allDisciplinas = repository.findAll(pages);
		
		return allDisciplinas;
	}

	@Override
	public Disciplina consultarDisciplinaById(Integer idDisciplina) {
		
		try {
			return repository.findById(idDisciplina).get();
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public Disciplina cadastrarDisciplina(Disciplina novaDisciplina) {
		novaDisciplina = repository.save(novaDisciplina);
		return novaDisciplina;
	}

	@Override
	public Disciplina alterarDisciplina(Disciplina alterarDisciplina) {
		return repository.save(alterarDisciplina);
	}

	@Override
	public void excluirDisciplina(Integer idDisciplina) {
		repository.deleteById(idDisciplina);
	}

	
}
