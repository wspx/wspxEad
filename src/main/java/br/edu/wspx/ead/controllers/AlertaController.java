package br.edu.wspx.ead.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.wspx.ead.entities.Alerta;
import br.edu.wspx.ead.services.AlertaService;



@RestController
@RequestMapping("api/alerta")
@CrossOrigin(origins = "*")
public class AlertaController {

	@Autowired
	private AlertaService service;
	
	
	//GET - Retorna uma lista com todos os usuarios
	@GetMapping()
	protected ResponseEntity<Page<Alerta>> getAllAlertas(){
		
		Page<Alerta> alertas = service.getAllAlertas(0, 10000);
		
		if(alertas == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(alertas);
	}
	
	
	
	//GET - Retorna um Alerta pelo ID
	@GetMapping("{id}")
	protected ResponseEntity<Alerta> consultarAlertaById(@PathVariable("id") Integer idAlerta){
		
		
		Alerta alerta = service.consultarAlertaById(idAlerta);
		
		if(alerta == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(alerta);
	}
	
	
	
	//POST - Cadastra um novo alerta no Banco
	@PostMapping()
	protected ResponseEntity<Alerta> cadastrarAlerta(@RequestBody Alerta novoAlerta){
		
		try {
			novoAlerta = service.cadastrarAlerta(novoAlerta);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(novoAlerta);
	}
	
	
	
	//PUT - Atualiza os dados de um alerta
	@PutMapping()
	protected ResponseEntity<Alerta> alterarAlerta(@RequestBody Alerta alerta){
		
		//Busca no Banco o alerta pelo ID
		Alerta alterarAlerta = service.consultarAlertaById(alerta.getIdAlerta());
		
		
		if(alterarAlerta == null)
			return ResponseEntity.notFound().build();
		
		
		try {
			alerta = service.alterarAlerta(alerta);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		
		return ResponseEntity.ok(alerta);
	}
	
	
	
	//DELETE - Deleta um alerta pelo ID
	@DeleteMapping("{id}")
	protected ResponseEntity<String> excluirAlerta(@PathVariable("id") Integer idAlerta){
		
		try {
			service.excluirAlerta(idAlerta);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok("{\"message\": \"Deletado com Sucesso!\"}");
	}
}
