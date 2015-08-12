package br.tur.reservafacil.test.lancamento;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.tur.reservafacil.model.conta.Lancamento;
import br.tur.reservafacil.model.conta.Lancamento.Tipo;

public class LancamentoTest {

	@Test
	public void lancamentoTipoCreditoRetornaValorPositivo(){
		Lancamento lancamento = new Lancamento(50.00, Tipo.C);
		
		assertEquals("Lancamento Tipo credito deve ser positivo", 50.00, lancamento.getValor(), 0.0);
	}
	
	@Test
	public void lancamentoTipoDebitoRetornaValorNegativo(){
		Lancamento lancamento = new Lancamento(50.00, Tipo.D);
		
		assertEquals("Lancamento Tipo debito deve ser positivo", -50.00, lancamento.getValor(), 0.0);
	}
}
