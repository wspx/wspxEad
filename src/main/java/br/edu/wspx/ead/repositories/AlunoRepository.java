package br.edu.wspx.ead.repositories;

import br.edu.wspx.ead.entities.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlunoRepository extends CrudRepository<Aluno, Integer>{
	
	Page<Aluno> findAll(Pageable page);
}
