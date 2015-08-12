package br.tur.reservafacil.model.taxa;



public class TaxaMinimoQuinzeDias implements TaxaOperacaoTipoC{

	private TaxaOperacaoTipoC proximoCalculo;

	public double valorTaxa(double valor, int diferencaEmDias){
		if(diferencaEmDias <= 15 ){
			return valor * 0.067;
		} else {
			return this.proximoCalculo.valorTaxa(valor, diferencaEmDias);
		}
	}

	public void proximoCalculo(TaxaOperacaoTipoC proximoCalculo) {
		this.proximoCalculo = proximoCalculo;		
	}
	
}
