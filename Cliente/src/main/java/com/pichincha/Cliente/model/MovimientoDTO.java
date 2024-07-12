package com.pichincha.Cliente.model;

import java.util.Date;

public class MovimientoDTO {

	private long id;
	private Date fecha;
	private String tipoMovimiento;
	private double valor;
	private double saldo;
	private long cuentaId;

	public MovimientoDTO() {
		// TODO Auto-generated constructor stub
	}

	public MovimientoDTO(long id, Date fecha, String tipoMovimiento, double valor, double saldo, long cuentaId) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
		this.valor = valor;
		this.saldo = saldo;
		this.cuentaId = cuentaId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public long getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(long cuentaId) {
		this.cuentaId = cuentaId;
	}

}
