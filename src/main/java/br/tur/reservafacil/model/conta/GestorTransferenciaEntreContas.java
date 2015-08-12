package br.tur.reservafacil.model.conta;

import br.tur.reservafacil.model.operacao.Operacao;


public class GestorTransferenciaEntreContas {

	public GestorTransferenciaEntreContas(Conta contaOrigem, Conta contaDestino,
			Operacao operacao) {
		
		contaOrigem.debitar(operacao.calcularTaxa(), "TAXA DE TRANSFERENCIA PARA C/C: " + contaDestino.numeroComDigito());
		contaOrigem.debitar(operacao.valor, "TRANFERENCIA PARA C/C: " + contaDestino.numeroComDigito());
		contaDestino.creditar(operacao.valor, "TRANSFERENCIA DE C/C: " + contaOrigem.numeroComDigito());
	}

}
