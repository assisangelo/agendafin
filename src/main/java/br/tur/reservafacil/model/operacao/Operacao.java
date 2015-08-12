package br.tur.reservafacil.model.operacao;

import java.util.Calendar;

public class Operacao {
	public double valor;
	public Calendar dataAgendamento;

	private TipoOperacaoTransferencia tipoOperacaoDeTransferencia;
	
	public Operacao(double d,
			TipoOperacaoTransferencia tipoOperacaoDeTransferencia,
			Calendar dataAgendamento) {
		super();
		this.valor = d;
		this.tipoOperacaoDeTransferencia = tipoOperacaoDeTransferencia;
		this.dataAgendamento = validarDataAgendamento(dataAgendamento);
	}
	
	public double calcularTaxa(){
		return tipoOperacaoDeTransferencia.calcularTaxa(valor, dataAgendamento);
	}
	
	private Calendar validarDataAgendamento(Calendar dataAgendamento) {
		Calendar now = Calendar.getInstance();
		
		if (dataAgendamento.before(now)) {
			throw new IllegalArgumentException("Data do agendamento nao deve ser anterior ao horario atual!");
		}
		
		return dataAgendamento;
	}

}