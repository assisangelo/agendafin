package br.tur.reservafacil.model.usuario;

import br.tur.reservafacil.model.conta.Conta;

public class Usuario {
	public String nome;
	public String login;
	
	public Conta conta;

	public Usuario(String nome) {
		this.nome = nome;
	}
	
	public void adicionarConta(Conta conta){
		this.conta = conta;
	}
	
	
}
