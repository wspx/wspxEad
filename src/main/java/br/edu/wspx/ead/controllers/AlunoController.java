package br.edu.wspx.ead.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.wspx.ead.entities.Aluno;
import br.edu.wspx.ead.services.AlunoService;


@RestController
@RequestMapping("api/aluno")
@CrossOrigin(origins = "*")
public class AlunoController {

	@Autowired
	private AlunoService service;
	
	//GET - Retornar uma lista com todos os Alunos
	@GetMapping
	protected ResponseEntity<Page<Aluno>> getAllAlunos(){
		
		Page<Aluno> alunos = service.getAllAlunos(0, 10000);
		
		if(alunos == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(alunos);
	}
	
	
	
	//GET - Retona um Aluno pelo Id
	@GetMapping("{id}")
	protected ResponseEntity<Aluno> getAlunoById(@PathVariable("id") Integer idAluno){
		
		Aluno aluno = service.consultarAlunoById(idAluno);
		
		if(aluno == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(aluno);
	}
	
	
	
	//POST - Cadastra um novo Aluno
	@PostMapping
	protected ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno novoAluno){
		
		try {
			novoAluno = service.cadastrarAluno(novoAluno);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(novoAluno);
	}
	
	
	
	//PUT - Atualiza os dados de uma Aluno
	@PutMapping
	protected ResponseEntity<Aluno> alterarAluno(@RequestBody Aluno alterarAluno){
		
		//Busca no Banco o Aluno pelo ID
		Aluno aluno = service.consultarAlunoById(alterarAluno.getIdAluno());
		
		if(aluno == null)
			return ResponseEntity.notFound().build();
		
		try {
			alterarAluno = service.alterarAluno(alterarAluno);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(alterarAluno);
	}
	
	
	
	//DELETE - Deleta um Aluno pelo ID
	@DeleteMapping("{id}")
	protected ResponseEntity<String> excluirAluno(@PathVariable("id") Integer idAluno){
		
		try {
			service.excluirAluno(idAluno);
		}catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok("{\"message\": \"Deletado com Sucesso!\"}");
	}
	
}
