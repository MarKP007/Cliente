package com.pichincha.Cliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.Cliente.model.Cliente;
import com.pichincha.Cliente.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Optional<Cliente> findById(long id) {
		return clienteRepository.findById(id);
	}

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void deleteById(long id) {
		clienteRepository.deleteById(id);
	}

}