package br.tur.reservafacil.test.conta;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import br.tur.reservafacil.model.conta.Conta;
import br.tur.reservafacil.model.operacao.Operacao;
import br.tur.reservafacil.model.operacao.OperacaoTransferenciaTipoA;
import br.tur.reservafacil.model.usuario.Usuario;


public class ContaTest {

	Usuario usuario = new Usuario("Teste");
	Conta conta;

	@Before
	public void setup(){
		conta = new Conta(usuario, 1234);
	}
	
	@Test
	public void deveCalcularDigito(){
		assertEquals("Calcular digito verificador.", 0, conta.getDigito());
	} 
	
	@Test
	public void deveCreditarValorAoSaldo(){
		Conta conta = new Conta(usuario, 1234l);
		conta.creditar(50.0);
		conta.creditar(50.0);
		assertEquals("Credito - saldo atual da conta", 100.0, conta.saldoAtual(), 0.0);
	}
	
	@Test
	public void deveDebitarValorAoSaldo(){
		conta.creditar(100.0);
		conta.debitar(50.0);
		assertEquals("Debito - saldo atual da conta", 50.0, conta.saldoAtual(), 0.01);
	}
	
	@Test
	public void deveContabilizarQuantidadeLancamentosRealizados(){
		conta.creditar(100.0);
		conta.creditar(10.5);
		conta.debitar(50.0);
		assertEquals("Quantidade de lancamentos", 3, conta.exibirExtrato().size(), 0.01);
	}
	
	@Test
	public void deveAtualizarSaldosContasEnvolvidasTransferencia(){
		Conta contaOrigem = new Conta(usuario, 1234);
		contaOrigem.creditar(200.0);
		
		Conta contaDestino = new Conta(usuario, 1234);
		contaDestino.creditar(50.0);
		
		Calendar dataAgendamento = Calendar.getInstance();
		dataAgendamento.set(2015, 10, 1);
		
		Operacao operacao = new Operacao(100.00, new OperacaoTransferenciaTipoA(), dataAgendamento);
		
		contaOrigem.transferir(contaDestino, operacao);
		
		assertEquals("O saldo atual na conta de origem", 95.0, contaOrigem.saldoAtual(), 0.01);
		
		assertEquals("O saldo atual na conta de destino", 150.0, contaDestino.saldoAtual(), 0.01);
	}
}

