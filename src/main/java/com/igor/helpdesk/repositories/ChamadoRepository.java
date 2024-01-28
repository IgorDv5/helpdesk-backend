package com.igor.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
