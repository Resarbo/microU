package com.universidad.service.feignclientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.universidad.service.modelos.Docentes;

@FeignClient(name = "docentes-service", url= "http://localhost:8002")
public interface DocentesFeignClient {
	@PostMapping("/docentes")
	public Docentes saveD(@RequestBody Docentes docentes);
	
	@GetMapping("/docentes/universidad/{universidadId}")
	public List<Docentes> getDocentes(@PathVariable("universidadId") int universidadId);
}