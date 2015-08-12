package br.tur.reservafacil.model.taxa;



public class TaxaMinimoDezDias implements TaxaOperacaoTipoC{

	private TaxaOperacaoTipoC proximoCalculo;

	public double valorTaxa(double valor, int diferencaEmDias){
		if(diferencaEmDias <= 10 ){
			return valor * 0.074;
		} else {
			return this.proximoCalculo.valorTaxa(valor, diferencaEmDias);
		}
	}

	public void proximoCalculo(TaxaOperacaoTipoC proximoCalculo) {
		this.proximoCalculo = proximoCalculo;		
	}
	
}
