package br.tur.reservafacil.model.operacao;

import java.util.Calendar;

public class OperacaoTransferenciaTipoB implements TipoOperacaoTransferencia {

	public double calcularTaxa(double valor, Calendar dataAgendamento) {
		
		Calendar dataReferencia = Calendar.getInstance();
		dataReferencia.add(Calendar.DAY_OF_MONTH, 31);
		
		if(dataAgendamento.before(dataReferencia)){
			return 10.0;
		}
		
		return 8.0;
	}

}
