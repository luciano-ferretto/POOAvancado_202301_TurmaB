package br.edu.atitus.pooavancado.CadUsuario.controllers.payloads;

import br.edu.atitus.pooavancado.CadUsuario.entities.Departamento;

public class SignupPayload {
	
	private String nome;
	private String email;
	private Departamento departamento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	

}
