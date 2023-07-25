package com.universidad.service.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universidad.service.entidades.Universidad;
import com.universidad.service.modelos.Aulas;
import com.universidad.service.modelos.Docentes;
import com.universidad.service.servicio.UniversidadService;

@RestController
@RequestMapping("/universidad")
public class UniversidadController {
	@Autowired
	UniversidadService universidadService;
	
	@GetMapping
	public ResponseEntity<List<Universidad>> listarUniversidades(){
		List<Universidad> universidades = universidadService.getAll();
		if(universidades.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(universidades);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Universidad> obtenerUniversidad(@PathVariable("id") int id){
		Universidad universidad = universidadService.getUniversidadById(id);
		if(universidad == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(universidad);
	}
	
	@PostMapping
	public ResponseEntity<Universidad> guardarUniversidad(@RequestBody Universidad universidad){
		Universidad nuevaUniversidad = universidadService.save(universidad);
		return ResponseEntity.ok(nuevaUniversidad);
	}
	
	@PostMapping("/docentes/{universidadId}")
	public ResponseEntity<Docentes> guardarDocentes(@PathVariable("universidadId") int universidadId,@RequestBody Docentes docentes){
		Docentes nuevoDocente = universidadService.saveDocentes(universidadId, docentes);
		return ResponseEntity.ok(nuevoDocente);
	} 
	
	@PostMapping("/aulas/{universidadId}")
	public ResponseEntity<Aulas> guardarAulas(@PathVariable("universidadId") int universidadId,@RequestBody Aulas aulas){
		Aulas nuevaAula = universidadService.saveAulas(universidadId, aulas);
		return ResponseEntity.ok(nuevaAula);
	} 
	
	@GetMapping("/todos/{universidadId}")
	public ResponseEntity<Map<String, Object>> listarTodosLosDocentesyAulas(@PathVariable("universidadId") int universidadId){
		Map<String,Object> resultado = universidadService.getUniversidadAndDocentesAndAulas(universidadId);
		return ResponseEntity.ok(resultado);
	}
}