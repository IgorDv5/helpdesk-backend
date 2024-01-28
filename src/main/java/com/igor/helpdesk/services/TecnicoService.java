package com.igor.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.helpdesk.domain.Tecnico;
import com.igor.helpdesk.repositories.TecnicoRepository;

@Service // Anotação Para Classes de Serviço
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElse(null);
	}

}