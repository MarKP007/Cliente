package com.pichincha.Cliente.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pichincha.Cliente.model.Cliente;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class ClienteRepositoryTest {

	@Autowired
	ClienteRepository clienteRepository;

	@Test
	void testCrearCliente() {
		Cliente cliente = new Cliente("Nombew", "G", 18, "1234567890", "Direccion", "+593984807956", "pasoword",
				"activo");
		Cliente clienteGuardado = clienteRepository.save(cliente);
		assertThat(clienteGuardado).isNotNull();
		assertThat(clienteGuardado.getId()).isGreaterThan(0);
	}

}
