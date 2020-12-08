package br.edu.wspx.ead.repositories;

import br.edu.wspx.ead.entities.Alerta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AlertaRepository extends CrudRepository<Alerta, Integer> {
	
	Page<Alerta> findAll(Pageable page);
}
