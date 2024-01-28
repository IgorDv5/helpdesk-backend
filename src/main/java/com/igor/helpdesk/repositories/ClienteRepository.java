package com.igor.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
