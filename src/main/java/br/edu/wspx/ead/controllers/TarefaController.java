package br.edu.wspx.ead.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.wspx.ead.entities.Tarefa;
import br.edu.wspx.ead.services.TarefaService;



@RestController
@RequestMapping("api/tarefa")
@CrossOrigin(origins = "*")
public class TarefaController {
	
	@Autowired
	private TarefaService service;
	
	
	
	//GET - Retorna uma lista com todas as tarefas
	@GetMapping()
	protected ResponseEntity<Page<Tarefa>> getAllTarefas(){
		
		Page<Tarefa> tarefas = service.getAllTarefas(0, 10000);
		
		if(tarefas == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(tarefas);
	}
	
	
	
	//GET - Retora uma Tarefa pelo ID
	@GetMapping("{id}")
	protected ResponseEntity<Tarefa> consultarTarefaById(@PathVariable("id") Integer idTarefa){
		
		Tarefa tarefa = service.consultarTarefaById(idTarefa);
		
		if(tarefa == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(tarefa);
	}
	
	
	
	//POST - Cadastra uma nova Tarefa no Banco de Dados
	@PostMapping()
	protected ResponseEntity<Tarefa> cadastrarTarefa(@RequestBody Tarefa novaTarefa){
		
		try {
			novaTarefa = service.cadastrarTarefa(novaTarefa);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(novaTarefa);
	}
	
	
	
	//PUT - Atualiza os dados de uma tarefa
	@PutMapping()
	protected ResponseEntity<Tarefa> alterarTarefa(@RequestBody Tarefa alterarTarefa){
		
		//Verifica se a tarefa passada pelo parametro existe no banco
		Tarefa tarefa = service.consultarTarefaById(alterarTarefa.getIdTarefa());
		
		if(tarefa == null)
			return ResponseEntity.notFound().build();
		
		try {
			alterarTarefa = service.alterarTarefa(alterarTarefa);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(alterarTarefa);
	}
	
	
	//DETELE - Deleta uma tarefa pelo ID
	@DeleteMapping("{id}")
	protected ResponseEntity<String> excluirTarefa(@PathVariable("id") Integer idTarefa){
		
		try {
			service.excluirTarefa(idTarefa);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok("{\"message\": \"Deletado com Sucesso!\"}");
	}
}
