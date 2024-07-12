package com.pichincha.Cliente.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name = "clientid")
@Table(name = "cliente")
public class Cliente extends Persona {

	@Column(name = "contrasena")
	private String contrasena;

	@Column(name = "estado")
	private String estado;

	@Transient
	private List<CuentaDTO> cuentas;

	public Cliente() {

	}

	public Cliente(String nombre, String genero, int edad, String identificacion, String direccion, String telefono,
			String contrasena, String estado) {
		setNombre(nombre);
		setGenero(genero);
		setEdad(edad);
		setIdentificacion(identificacion);
		setDireccion(direccion);
		setTelefono(telefono);
		this.contrasena = contrasena;
		this.estado = estado;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<CuentaDTO> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<CuentaDTO> cuentas) {
		this.cuentas = cuentas;
	}

	@Override
	public String toString() {
		return "Tutorial [personaId=" + getId() + ", contrasena=" + contrasena + ", estado=" + estado + "]";
	}

}
