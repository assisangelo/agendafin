package br.tur.reservafacil.model.conta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.tur.reservafacil.model.conta.Lancamento.Tipo;
import br.tur.reservafacil.model.operacao.Operacao;
import br.tur.reservafacil.model.usuario.Usuario;

public class Conta {
	public long numero;
	public long digito;
	
	public Usuario usuario;
	
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	
	public Conta(Usuario usuario, long numero) {
		this.usuario = usuario;
		this.numero = numero;
		
		calculaDigito();
	}
	
	private void calculaDigito(){
		this.digito = 0l;
	}
	
	public long getDigito() {
		return 0l;
	}
	
	public String numeroComDigito() {
		return this.numero + "-" + this.digito;
	}
	
	public double saldoAtual(){
		double total = 0.0;
		
		for (Lancamento lancamento : lancamentos) {
			total += lancamento.getValor(); 
		}
		return total;
	}

	public void creditar(double valor) {
		lancarValor(valor, Tipo.C, "");
	}
	
	public void creditar(double valor, String descricao) {
		lancarValor(valor, Tipo.C, descricao);
	}
	
	public void debitar(double valor) {
		lancarValor(valor, Tipo.D, "");			
	}
	
	public void debitar(double valor, String descricao) {
		lancarValor(valor, Tipo.D, descricao);			
	}
	
	private void lancarValor(double valor, Tipo tipo, String descricao){
		double valorLancamento = 0.0;
		
		if(valor < 0){
			valorLancamento = valor * -1;
		}
		valorLancamento = valor;
		
		lancamentos.add(new Lancamento(valorLancamento, tipo, descricao));
	}
	
	public Collection<Lancamento> exibirExtrato(){
		return Collections.unmodifiableCollection(this.lancamentos);
	}

	public void transferir(Conta contaDestino, Operacao operacao) {
		new GestorTransferenciaEntreContas(this,contaDestino, operacao);
	}
}
