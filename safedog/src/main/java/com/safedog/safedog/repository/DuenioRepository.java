package com.safedog.safedog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.safedog.safedog.model.Duenio;

public interface DuenioRepository extends JpaRepository <Duenio, Long> {
	@Query("SELECT d FROM Duenio d WHERE d.correo = ?1 ")
    Duenio findByEmail(String correo);
	
	@Query(value = "SELECT id_dueño FROM duenios ORDER BY id_dueño DESC LIMIT 1", nativeQuery = true)
	    Long findLastId();
}
