package com.pichincha.Cliente.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pichincha.Cliente.model.Cliente;
import com.pichincha.Cliente.model.CuentaDTO;
import com.pichincha.Cliente.model.MovimientoDTO;
import com.pichincha.Cliente.repository.CuentaClient;
import com.pichincha.Cliente.service.ClienteService;

@RestController
@RequestMapping()
public class ReportesController {

	@Autowired
	ClienteService clienteService;

	@Autowired
	private CuentaClient cuentaClient;

	@GetMapping("/reportes")
	public ResponseEntity<Cliente> reporteMovimientos(@RequestParam long id,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {

		Optional<Cliente> clienteData = clienteService.findById(id);

		if (clienteData.isPresent()) {
			List<CuentaDTO> cuentas = cuentaClient.getCuentasByClienteId(id);
			for (CuentaDTO cuentaDTO : cuentas) {
				List<MovimientoDTO> movimientos = cuentaClient.reporteMovimientos(cuentaDTO.getId(), startDate,
						endDate);
				cuentaDTO.setMovimientos(movimientos);
			}
			Cliente cliente = clienteData.get();
			cliente.setCuentas(cuentas);
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
