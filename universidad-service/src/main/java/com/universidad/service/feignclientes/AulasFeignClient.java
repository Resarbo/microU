package com.universidad.service.feignclientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.universidad.service.modelos.Aulas;

@FeignClient(name = "aulas-service", url= "http://localhost:8003")
public interface AulasFeignClient {
	@PostMapping("/aulas")
	public Aulas saveA(@RequestBody Aulas aulas);
	
	@GetMapping("/aulas/universidad/{universidadId}")
	public List<Aulas> getAulas(@PathVariable("universidadId") int universidadId);
}
