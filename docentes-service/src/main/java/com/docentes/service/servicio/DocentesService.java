package com.docentes.service.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docentes.service.entidades.Docentes;
import com.docentes.service.repositorio.DocentesRepository;

@Service
public class DocentesService {
	@Autowired
	private DocentesRepository docentesRepository;
	
	public List<Docentes> getAll(){
		return docentesRepository.findAll();
	}
	
	public Docentes getDocenteById(int id) {
		return docentesRepository.findById(id).orElse(null);
	}
	
	public Docentes save(Docentes docentes) {
		Docentes nuevoDocente = docentesRepository.save(docentes);
		return nuevoDocente;
	}
	
	public List<Docentes> byUniversidadId(int universidadId){
		return docentesRepository.findByUniversidadId(universidadId);
	}
	
}
