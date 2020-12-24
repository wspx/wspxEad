package br.edu.wspx.ead.repositories;

import br.edu.wspx.ead.entities.Disciplina;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DisciplinaRepository extends CrudRepository<Disciplina, Integer> {
	
	Page<Disciplina> findAll(Pageable page);
}
