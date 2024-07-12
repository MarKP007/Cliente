package com.pichincha.Cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pichincha.Cliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
