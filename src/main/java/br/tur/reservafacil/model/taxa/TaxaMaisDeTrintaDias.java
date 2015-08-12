package br.tur.reservafacil.model.taxa;


public class TaxaMaisDeTrintaDias implements TaxaOperacaoTipoC {

	public double valorTaxa(double valor, int diferencaEmDias) {
		return valor * 0.012;
	}

	public void proximoCalculo(TaxaOperacaoTipoC proximoCalculo) {
	}

}
