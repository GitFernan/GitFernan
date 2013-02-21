package com.microforum.gestorencuestas.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="USERS")
public class DatosLogin {
	@Id
	@Column(name="user_name")
	private String userName;
	@Column(name="user_pass")
	private String password;
	@OneToOne(mappedBy="datosLogin")
	private Usuario usuario;
	
	// Métodos Get/SEt
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
