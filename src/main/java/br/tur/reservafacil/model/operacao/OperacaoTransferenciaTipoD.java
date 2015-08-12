package br.tur.reservafacil.model.operacao;

import java.util.Calendar;

public class OperacaoTransferenciaTipoD implements TipoOperacaoTransferencia {

	public double calcularTaxa(double valor, Calendar dataAgendamento) {
		
		if(valor <= 25000.0){
			return new OperacaoTransferenciaTipoA().calcularTaxa(valor, dataAgendamento);
		}
		
		if (valor >= 25001.0 && valor <= 120000.0) {
			return new OperacaoTransferenciaTipoB().calcularTaxa(valor, dataAgendamento);
		}
				
		return new OperacaoTransferenciaTipoC().calcularTaxa(valor, dataAgendamento);
	}

}
