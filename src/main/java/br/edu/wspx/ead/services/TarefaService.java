package br.edu.wspx.ead.services;

import br.edu.wspx.ead.entities.Tarefa;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public interface TarefaService {
	
	Page<Tarefa> getAllTarefas(Integer pagina, Integer qtdItens);
	Tarefa consultarTarefaById(Integer idTarefa);
	Tarefa cadastrarTarefa(Tarefa novaTarefa);
	Tarefa alterarTarefa(Tarefa alterarTarefa);
	void excluirTarefa(Integer idTarefa);
}
