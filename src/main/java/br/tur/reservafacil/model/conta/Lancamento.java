package br.tur.reservafacil.model.conta;

public class Lancamento {
	public enum Tipo {C,D};
	
	public String descricao;
	
	private Tipo tipo;
	private double valor;
	 
	public Lancamento(double valor, Tipo tipo) {
		this.valor = valor;
		this.tipo = tipo;
		this.descricao = "";
	}
	
	public Lancamento(double valor, Tipo tipo, String descricao) {
		this.valor = valor;
		this.tipo = tipo;
		this.descricao = descricao;
	}
	
	public double getValor(){
		if(tipo == Tipo.D){
			return -valor;
		}
		
		return valor;
	}
}
