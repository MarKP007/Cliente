package com.pichincha.Cliente.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.pichincha.Cliente.model.Cliente;
import com.pichincha.Cliente.repository.CuentaClient;
import com.pichincha.Cliente.service.ClienteService;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ClienteService ClienteService;

	@MockBean
	CuentaClient cuentaClient;

	@Test
	void testGetAllResponseOKWithListNotEmpty() throws Exception {
		List<Cliente> clientes = new ArrayList<Cliente>();
		Cliente cliente = new Cliente("nombre", "M", 38, "1234567890", "vista hermosa", "0984807956", "1234", "True");
		clientes.add(cliente);
		when(ClienteService.findAll()).thenReturn(clientes);
		mockMvc.perform(MockMvcRequestBuilders.get("/clientes").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpectAll(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

	@Test
	void testGetResponseOKWhenClientExits() throws Exception {
		Cliente cliente = new Cliente("nombre", "M", 38, "1234567890", "vista hermosa", "0984807956", "1234", "True");
		when(ClienteService.findById(9999L)).thenReturn(Optional.of(cliente));
		when(cuentaClient.getCuentasByClienteId(9999L)).thenReturn(new ArrayList<>());
		mockMvc.perform(MockMvcRequestBuilders.get("/clientes/9999").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpectAll(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
}
