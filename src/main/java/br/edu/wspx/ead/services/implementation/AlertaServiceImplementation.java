package br.edu.wspx.ead.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.wspx.ead.entities.Alerta;
import br.edu.wspx.ead.services.AlertaService;
import br.edu.wspx.ead.repositories.AlertaRepository;


@Service
public class AlertaServiceImplementation implements AlertaService{
	
	@Autowired
	private AlertaRepository repository;
	
	@Override
	public Page<Alerta> getAllAlertas(Integer pagina, Integer qtdItens) {
		
		Pageable pages = PageRequest.of(pagina, qtdItens);
		Page<Alerta> allAlertas = repository.findAll(pages);
		
		return allAlertas;
	}

	@Override
	public Alerta consultarAlertaById(Integer idAlerta) {
		
		try {
			return repository.findById(idAlerta).get();
		}catch(Exception e) {
			return null;
		}		
	}

	@Override
	public Alerta cadastrarAlerta(Alerta novoAlerta) {
		novoAlerta = repository.save(novoAlerta);
		return novoAlerta;
	}

	@Override
	public Alerta alterarAlerta(Alerta alterarAlerta) {
		return repository.save(alterarAlerta);
	}

	@Override
	public void excluirAlerta(Integer idAlerta) {
		repository.deleteById(idAlerta);
	}	
}