package br.edu.wspx.ead.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.wspx.ead.entities.Disciplina;
import br.edu.wspx.ead.services.DisciplinaService;


@RestController
@RequestMapping("api/disciplina")
@CrossOrigin(origins = "*")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService service;
	
	
	//GET - Retorna uma lista com todas as Disciplinas
	@GetMapping
	protected ResponseEntity<Page<Disciplina>> getAllDisciplinas(){
		
		Page<Disciplina> disciplinas = service.getAllDisciplinas(0, 10000);
		
		if(disciplinas == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(disciplinas);
	}
	
	
	
	//GET - Retorna uma Disciplina pelo ID
	@GetMapping("{id}")
	protected ResponseEntity<Disciplina> getDisciplinaById(@PathVariable("id") Integer idDisciplina){
		
		Disciplina disciplina = service.consultarDisciplinaById(idDisciplina);
		
		if(disciplina == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(disciplina);
	}
	
	
	
	//POST - Cadastra uma nova Disciplina
	@PostMapping
	protected ResponseEntity<Disciplina> cadastrarDisciplina(@RequestBody Disciplina novaDisciplina){
		
		try {
			novaDisciplina = service.cadastrarDisciplina(novaDisciplina);
		}catch(Exception e) {
			//e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(novaDisciplina);
	}
	
	
	
	//PUT - Atualiza os dados de uma Disciplina
	@PutMapping
	protected ResponseEntity<Disciplina> alterarDisciplina(@RequestBody Disciplina alterarDisciplina){
		
		//Busca no Banco a Disciplina pelo ID
		Disciplina disciplina = service.consultarDisciplinaById(alterarDisciplina.getIdDisciplina());
		
		if(disciplina == null)
			return ResponseEntity.notFound().build();
		
		try {
			alterarDisciplina = service.alterarDisciplina(alterarDisciplina);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(alterarDisciplina);
	}
	
	
	
	//DELETE - Deleta uma Disciplina pelo ID
	@DeleteMapping("{id}")
	protected ResponseEntity<String> excluirDisciplina(@PathVariable("id") Integer idDisciplina){
		
		try {
			service.excluirDisciplina(idDisciplina);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok("{\"message\": \"Deletado com Sucesso!\"}");
	}
	
}
