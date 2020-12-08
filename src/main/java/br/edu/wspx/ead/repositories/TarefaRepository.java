package br.edu.wspx.ead.repositories;

import br.edu.wspx.ead.entities.Tarefa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TarefaRepository extends CrudRepository<Tarefa, Integer>{
	
	Page<Tarefa> findAll(Pageable page);
}
