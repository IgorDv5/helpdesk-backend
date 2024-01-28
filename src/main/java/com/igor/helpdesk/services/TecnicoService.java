package com.igor.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.helpdesk.domain.Tecnico;
import com.igor.helpdesk.repositories.TecnicoRepository;
import com.igor.helpdesk.services.exceptions.ObjectNotFoundException;

@Service // Anotação Para Classes de Serviço
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Nao Encontrado! Id: " + id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

}
