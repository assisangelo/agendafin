package br.tur.reservafacil.model.taxa;



public class TaxaMinimoVinteDias implements TaxaOperacaoTipoC{

	private TaxaOperacaoTipoC proximoCalculo;

	public double valorTaxa(double valor, int diferencaEmDias){

		if(diferencaEmDias <= 20 ){
			return valor * 0.054;
		} else {
			return this.proximoCalculo.valorTaxa(valor, diferencaEmDias);
		}
	}

	public void proximoCalculo(TaxaOperacaoTipoC proximoCalculo) {
		this.proximoCalculo = proximoCalculo;		
	}
	
}
