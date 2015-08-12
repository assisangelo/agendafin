package br.tur.reservafacil.model.taxa;



public class TaxaMinimoTrintaDias implements TaxaOperacaoTipoC{

	private TaxaOperacaoTipoC proximoCalculo;

	public double valorTaxa(double valor, int diferencaEmDias){
		if(diferencaEmDias <= 30){
			return valor * 0.021;
		} else {
			return this.proximoCalculo.valorTaxa(valor, diferencaEmDias);
		}
	}

	public void proximoCalculo(TaxaOperacaoTipoC proximoCalculo) {
		this.proximoCalculo = proximoCalculo;		
	}
	
}
