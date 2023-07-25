package com.aulas.service.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulas.service.entidades.Aulas;

@Repository
public interface AulasRepository extends JpaRepository<Aulas, Integer>{
	List<Aulas> findByUniversidadId(int universidadId);
}
