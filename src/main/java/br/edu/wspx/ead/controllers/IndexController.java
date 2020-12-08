package br.edu.wspx.ead.controllers;


import java.util.HashMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class IndexController {
	
	@GetMapping()
	protected HashMap<String, Object> infosAPI(){
		
		HashMap<String, Object> map = new HashMap<>();
		
	    map.put("RA", 100942);
	    map.put("Aluno", "William da Silva Pereira");
	    map.put("Curso", "Ciência da Computação");
	    map.put("Instituicao", "Centro Universitário Adventista de São Paulo");
	    map.put("Campus", "SP");
	    map.put("Disciplina", "Tecnologia Web");
	    map.put("Semestre", 8);
	    map.put("Descricao", "Esta é uma simples API desenvolvida como trabalho para esta disciplina");
	    map.put("Professor", "Ali Ahmad Hassan");
	    
	    return map;
	}
}
