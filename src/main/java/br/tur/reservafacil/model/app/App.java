package br.tur.reservafacil.model.app;

import br.tur.reservafacil.model.conta.Conta;
import br.tur.reservafacil.model.usuario.Usuario;

public class App {

	public static void main(String[] args) {
		
		Usuario usuario = new Usuario("Teste1");
		
		Conta conta = new Conta(usuario, 1234);
		conta.creditar(50.0, "Deposito inicial");
		
		
		
		
		

	}

}
