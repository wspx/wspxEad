package br.edu.wspx.ead.services;

import br.edu.wspx.ead.entities.Alerta;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public interface AlertaService {

	Page<Alerta> getAllAlertas(Integer pagina, Integer qtdItens);
	Alerta consultarAlertaById(Integer idAlerta);
	Alerta cadastrarAlerta(Alerta novoAlerta);
	Alerta alterarAlerta(Alerta alterarAlerta);
	void excluirAlerta(Integer idAlerta);
}
