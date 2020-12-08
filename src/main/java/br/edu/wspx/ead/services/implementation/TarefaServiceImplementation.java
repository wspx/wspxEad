package br.edu.wspx.ead.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.wspx.ead.entities.Tarefa;
import br.edu.wspx.ead.services.TarefaService;
import br.edu.wspx.ead.repositories.TarefaRepository;


@Service
public class TarefaServiceImplementation implements TarefaService{

	@Autowired
	private TarefaRepository repository;
	
	
	@Override
	public Page<Tarefa> getAllTarefas(Integer pagina, Integer qtdItens) {
		
		Pageable pages = PageRequest.of(pagina, qtdItens);
		Page<Tarefa> allTarefas = repository.findAll(pages);
		
		return allTarefas;
	}

	@Override
	public Tarefa consultarTarefaById(Integer idTarefa) {
		
		try {
			return repository.findById(idTarefa).get();
		}catch(Exception e) {
			return null;
		}
	}

	@Override
	public Tarefa cadastrarTarefa(Tarefa novaTarefa) {
		novaTarefa = repository.save(novaTarefa);
		return novaTarefa;
	}

	@Override
	public Tarefa alterarTarefa(Tarefa alterarTarefa) {
		return repository.save(alterarTarefa);
	}

	@Override
	public void excluirTarefa(Integer idTarefa) {
		repository.deleteById(idTarefa);
	}
}