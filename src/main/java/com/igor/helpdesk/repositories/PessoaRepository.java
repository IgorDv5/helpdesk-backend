package com.igor.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}