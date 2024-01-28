package com.igor.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.helpdesk.domain.Pessoa;
import com.igor.helpdesk.domain.Tecnico;
import com.igor.helpdesk.domain.dtos.TecnicoDTO;
import com.igor.helpdesk.repositories.PessoaRepository;
import com.igor.helpdesk.repositories.TecnicoRepository;
import com.igor.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.igor.helpdesk.services.exceptions.ObjectNotFoundException;

@Service // Anotação Para Classes de Serviço
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Nao Encontrado! Id: " + id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
	}

	private void validaPorCpfEEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já Cadastrado No Sistema!");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getEmail() != objDTO.getEmail()) {
			throw new DataIntegrityViolationException("E-mail Já Cadastrado No Sistema!");
		}
	}

}
