package br.tur.reservafacil.model.operacao;

import java.util.Calendar;

public interface TipoOperacaoTransferencia {

	public double calcularTaxa(double valor, Calendar dataAgendamento); 
}
