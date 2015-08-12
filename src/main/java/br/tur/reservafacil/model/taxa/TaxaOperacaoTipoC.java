package br.tur.reservafacil.model.taxa;

public interface TaxaOperacaoTipoC {
	double valorTaxa(double valor, int diferencaEmDias);
	void proximoCalculo(TaxaOperacaoTipoC proximoCalculo);
}
