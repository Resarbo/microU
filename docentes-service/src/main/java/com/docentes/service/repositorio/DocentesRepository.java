package com.docentes.service.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docentes.service.entidades.Docentes;

@Repository
public interface DocentesRepository extends JpaRepository<Docentes, Integer>{
	List<Docentes> findByUniversidadId(int universidadId);
}
