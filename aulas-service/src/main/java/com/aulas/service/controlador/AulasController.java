package com.aulas.service.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.service.entidades.Aulas;
import com.aulas.service.servicio.AulasService;

@RestController
@RequestMapping("/aulas")
public class AulasController {
	@Autowired
	private AulasService aulasService;
	
	@GetMapping
	public ResponseEntity<List<Aulas>> listarAulas(){
		List<Aulas> aulas = aulasService.getAll();
		if(aulas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(aulas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aulas> obtenerAula(@PathVariable("id") int id){
		Aulas aula= aulasService.getAulasById(id);
		if(aula == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(aula);
	}
	
	@PostMapping
	public ResponseEntity<Aulas> guardarAula(@RequestBody Aulas aula){
		Aulas nuevaAula = aulasService.save(aula);
		return ResponseEntity.ok(nuevaAula);
	}
	
	@GetMapping("/universidad/{universidadId}")
	public ResponseEntity<List<Aulas>> listarAulasPorUniversidadId(@PathVariable("universidadId") int id){
		List<Aulas> aulas = aulasService.byUniversidadId(id);
		if(aulas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(aulas);
	}
}
