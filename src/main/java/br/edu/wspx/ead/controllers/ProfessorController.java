package br.edu.wspx.ead.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.wspx.ead.entities.Professor;
import br.edu.wspx.ead.services.ProfessorService;


@RestController
@RequestMapping("api/professor")
@CrossOrigin(origins = "*")
public class ProfessorController {
	
	@Autowired
	private ProfessorService service;
	
	
	
	//GET - Retorna uma lista com todos os Professor
	@GetMapping
	protected ResponseEntity<Page<Professor>> getAllProfessores(){
		
		Page<Professor> professores = service.getAllProfessores(0, 10000);
		
		if(professores == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(professores);
	}
	
	
	
	//GET Retorna um professor pelo ID
	@GetMapping("{id}")
	protected ResponseEntity<Professor> getProfessorById(@PathVariable("id") Integer idProfessor){
		
		Professor professor = service.consultarProfessorById(idProfessor);
		
		if(professor == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(professor);
	}
	
	
	
	//POST - Cadastra um novo Professor
	@PostMapping
	protected ResponseEntity<Professor> cadastarProfessor(@RequestBody Professor novoProfessor){
		
		try {
			novoProfessor = service.cadastrarProfessor(novoProfessor);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(novoProfessor);
	}
	
	
	
	
	//PUT - Atualiza os dados de um Professor
	@PutMapping
	protected ResponseEntity<Professor> alterarProfessor(@RequestBody Professor alterarProfessor){
		
		//Busca no Banco o Professor pelo ID
		Professor professor = service.consultarProfessorById(alterarProfessor.getIdProfessor());
		
		if(professor == null)
			return ResponseEntity.notFound().build();
		
		try {
			alterarProfessor = service.alterarProfessor(alterarProfessor);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(alterarProfessor);
	}
	
	
	
	//DELETE - Deleta um Professor pelo ID
	@DeleteMapping("{id}")
	protected ResponseEntity<String> excluirProfessor(@PathVariable("id") Integer idProfessor){
		
		try {
			service.excluirProfessor(idProfessor);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok("{\"message\": \"Deletado com Sucesso!\"}");
	}
	

}
