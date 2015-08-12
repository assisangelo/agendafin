package br.tur.reservafacil.model.operacao;

import java.util.Calendar;

public class OperacaoTransferenciaTipoA implements TipoOperacaoTransferencia {

	public double calcularTaxa(double valor, Calendar dataAgendamento) {
		return (valor*0.03) + 2;
	}

}
