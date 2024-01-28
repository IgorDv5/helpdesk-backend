package com.igor.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.helpdesk.domain.Chamado;
import com.igor.helpdesk.repositories.ChamadoRepository;
import com.igor.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;

	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado Id: " + id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

}
