package com.universidad.service.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidad.service.entidades.Universidad;
import com.universidad.service.feignclientes.AulasFeignClient;
import com.universidad.service.feignclientes.DocentesFeignClient;
import com.universidad.service.modelos.Aulas;
import com.universidad.service.modelos.Docentes;
import com.universidad.service.repositorio.UniversidadRepository;

@Service
public class UniversidadService {
	@Autowired
	private UniversidadRepository universidadRepository;
	
	@Autowired
	private DocentesFeignClient docentesFeignClient;
	
	@Autowired
	private AulasFeignClient aulasFeignClient;
	
	public List<Universidad> getAll() {
		return universidadRepository.findAll();
	}

	public Universidad getUniversidadById(int id) {
		return universidadRepository.findById(id).orElse(null);
	}

	public Universidad save(Universidad universidad) {
		Universidad nuevoUsuario = universidadRepository.save(universidad);
		return nuevoUsuario;
	}
	
	public Docentes saveDocentes(int universidadId, Docentes docentes) {
		docentes.setUniversidadId(universidadId);
		Docentes nuevoDocente = docentesFeignClient.saveD(docentes);
		return nuevoDocente;
	}
	
	public Aulas saveAulas(int universidadId, Aulas aulas) {
		aulas.setUniversidadId(universidadId);
		Aulas nuevaAula = aulasFeignClient.saveA(aulas);
		return nuevaAula;
	}
	
	public Map<String, Object> getUniversidadAndDocentesAndAulas(int universidadId){
		Map<String,Object> resultado = new HashMap<>();
		Universidad universidad = universidadRepository.findById(universidadId).orElse(null);
		
		if(universidad == null) {
			resultado.put("Mensaje", "La universidad no existe");
			return resultado;
		}
		resultado.put("Universidad",universidad);
		
		List<Docentes> docentes = docentesFeignClient.getDocentes(universidadId);
		if(docentes.isEmpty()) {
			resultado.put("Docentes", "La universidad no tiene docentes");
		}
		else {
			resultado.put("Docentes", docentes);
		}
		
		List<Aulas> aulas = aulasFeignClient.getAulas(universidadId);
		if(aulas.isEmpty()) {
			resultado.put("Aulas", "La universidad no tiene esa aula");
		}
		else {
			resultado.put("Aulas", aulas);
		}
		return resultado;
	}
}
