package br.edu.wspx.ead.repositories;

import br.edu.wspx.ead.entities.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProfessorRepository extends CrudRepository<Professor, Integer>{

	Page<Professor> findAll(Pageable page);
	Professor findProfessorByEmailAndSenha(String Email, String Senha);
}
