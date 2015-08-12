package br.tur.reservafacil.model.taxa;

public class TaxaMinimoCincoDias implements TaxaOperacaoTipoC{

	private TaxaOperacaoTipoC proximoCalculo;

	public double valorTaxa(double valor, int diferencaEmDias){
		if(diferencaEmDias <= 5){
			return valor * 0.083;
		} else {
			return this.proximoCalculo.valorTaxa(valor, diferencaEmDias);
		}
	}

	public void proximoCalculo(TaxaOperacaoTipoC proximoCalculo) {
		this.proximoCalculo = proximoCalculo;		
	}
	
}
