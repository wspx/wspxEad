package br.edu.wspx.ead.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.wspx.ead.entities.Login;
import br.edu.wspx.ead.entities.Aluno;
import br.edu.wspx.ead.entities.Professor;
import br.edu.wspx.ead.services.AlunoService;
import br.edu.wspx.ead.services.ProfessorService;


@RestController
@RequestMapping("api/login")
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private ProfessorService professorService;
	
	
	
	@PostMapping
	protected ResponseEntity<Object> logarUsuario(@RequestBody Login login){
		
		String tipoPerfil = login.getPerfil();
		
		//Caso o perfil seja Aluno
		if( tipoPerfil.equals("Aluno")) {
			
			Aluno aluno = alunoService.logar(login.getEmail(), login.getSenha());
			
			if(aluno == null)
				return ResponseEntity.notFound().build();
			
			aluno.setSenha("");
			
			return ResponseEntity.ok(aluno);
		}
		
		//Caso o perfil seja Professor
		else if (tipoPerfil.equals("Professor")) {
			
			Professor professor = professorService.logar(login.getEmail(), login.getSenha());
			
			if(professor == null)
				return ResponseEntity.notFound().build();
			
			professor.setSenha("");
			
			return ResponseEntity.ok(professor);
		}
		
		return ResponseEntity.badRequest().body("{\"message\": \"Usuario Não Encontrado!\"}");
	}
}
