package com.aulas.service.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulas.service.entidades.Aulas;
import com.aulas.service.repositorio.AulasRepository;

@Service
public class AulasService {
	@Autowired
	private AulasRepository aulasRepository;
	
	public List<Aulas> getAll(){
		return aulasRepository.findAll();
	}
	
	public Aulas getAulasById(int id) {
		return aulasRepository.findById(id).orElse(null);
	}
	
	public Aulas save(Aulas aulas) {
		Aulas nuevaAula = aulasRepository.save(aulas);
		return nuevaAula;
	}
	
	public List<Aulas> byUniversidadId(int universidadId){
		return aulasRepository.findByUniversidadId(universidadId);
	}
}
