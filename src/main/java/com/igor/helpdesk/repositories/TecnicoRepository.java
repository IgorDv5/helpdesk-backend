package com.igor.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
