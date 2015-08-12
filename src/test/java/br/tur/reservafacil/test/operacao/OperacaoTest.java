package br.tur.reservafacil.test.operacao;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import br.tur.reservafacil.model.operacao.OperacaoTransferenciaTipoA;
import br.tur.reservafacil.model.operacao.OperacaoTransferenciaTipoB;
import br.tur.reservafacil.model.operacao.OperacaoTransferenciaTipoC;
import br.tur.reservafacil.model.operacao.OperacaoTransferenciaTipoD;

public class OperacaoTest {

	double taxa;
	Calendar dataAgendamento;

	@Before
	public void prepararTestes() {
		this.taxa = 0;
		this.dataAgendamento = Calendar.getInstance();
	}

	@Test
	public void deveCalcularTaxaOperacaoTipoA() {
		this.taxa = new OperacaoTransferenciaTipoA().calcularTaxa(100.0,
				dataAgendamento);

		assertEquals("Taxa para operacoes do tipo A", 5.0, taxa, 0.01);
	}

	@Test
	public void deveCalcularTaxaOperacaoTipoBAnteriorTrintaDias() {

		this.taxa = new OperacaoTransferenciaTipoB().calcularTaxa(100.0,
				dataAgendamento);

		assertEquals("Taxa para operacoes do tipo B anterior a 30 dias", 10.0,
				taxa, 0.01);
	}

	@Test
	public void deveCalcularTaxaOperacaoTipoBPosteriorTrintaDias() {
		this.dataAgendamento.set(2015, 11, 10);

		this.taxa = new OperacaoTransferenciaTipoB().calcularTaxa(100.0,
				dataAgendamento);

		assertEquals("Taxa para operacoes do tipo B posterior a 30 dias", 8.0,
				taxa, 0.01);
	}

	@Test
	public void deveCalcularTaxaOperacaoTipoCMinimoCincoDias() {
		this.dataAgendamento.add(Calendar.DAY_OF_MONTH, 5);

		this.taxa = new OperacaoTransferenciaTipoC().calcularTaxa(100.0,
				dataAgendamento);

		assertEquals("Taxa para operacoes do tipo C minimo 5 dias", 8.3, taxa,
				0.01);
	}

	@Test
	public void deveCalcularTaxaOperacaoTipoCMinimoDezDias() {
		this.dataAgendamento.add(Calendar.DAY_OF_MONTH, 10);

		this.taxa = new OperacaoTransferenciaTipoC().calcularTaxa(100.0,
				dataAgendamento);

		assertEquals("Taxa para operacoes do tipo C minimo 10 dias", 7.4, taxa,
				0.01);
	}

	@Test
	public void deveCalcularTaxaOperacaoTipoCMinimoQuinzeDias() {
		this.dataAgendamento.add(Calendar.DAY_OF_MONTH, 15);

		this.taxa = new OperacaoTransferenciaTipoC().calcularTaxa(100.0,
				dataAgendamento);

		assertEquals("Taxa para operacoes do tipo C minimo 15 dias", 6.7, taxa,
				0.01);
	}

	@Test
	public void deveCalcularTaxaOperacaoTipoCMinimoVinteDias() {
		this.dataAgendamento.add(Calendar.DAY_OF_MONTH, 20);

		this.taxa = new OperacaoTransferenciaTipoC().calcularTaxa(100.0,
				dataAgendamento);

		assertEquals("Taxa para operacoes do tipo C minimo 20 dias", 5.4, taxa,
				0.01);
	}

	@Test
	public void deveCalcularTaxaOperacaoTipoCMinimoVinteCincoDias() {
		this.dataAgendamento.add(Calendar.DAY_OF_MONTH, 25);

		this.taxa = new OperacaoTransferenciaTipoC().calcularTaxa(100.0,
				dataAgendamento);

		assertEquals("Taxa para operacoes do tipo C minimo 25 dias", 4.3, taxa,
				0.01);
	}

	@Test
	public void deveCalcularTaxaOperacaoTipoCMinimoTrintaDias() {
		this.dataAgendamento.add(Calendar.DAY_OF_MONTH, 30);

		this.taxa = new OperacaoTransferenciaTipoC().calcularTaxa(100.0,
				dataAgendamento);

		assertEquals("Taxa para operacoes do tipo C minimo 30 dias", 2.1, taxa,
				0.01);
	}

	@Test
	public void deveCalcularTaxaOperacaoTipoCMaiorTrintaDias() {
		this.dataAgendamento.add(Calendar.DAY_OF_MONTH, 33);

		this.taxa = new OperacaoTransferenciaTipoC().calcularTaxa(100.0,
				dataAgendamento);

		assertEquals("Taxa para operacoes do tipo C maior 30 dias", 1.2, taxa,
				0.01);
	}

	@Test
	public void deveCalcularTaxaOperacaoTipoDMinimoVinteCincoMil() {
		this.taxa = new OperacaoTransferenciaTipoD().calcularTaxa(25000.0,
				dataAgendamento);

		assertEquals("Taxa para operacoes do tipo D minimo R$25.000,00", 752.0,
				taxa, 0.01);
	}

	@Test
	public void calcularTaxaOperacaoTipoDMaiorVinteCincoMilEMenorCentoVinteMil() {
		this.taxa = new OperacaoTransferenciaTipoD().calcularTaxa(50000.0,
				dataAgendamento);

		assertEquals(
				"Taxa operacoes do tipo D maior que 25.000 e menor que 120.000 e anterior a 30 dias",
				10.0, taxa, 0.01);
	}

	@Test
	public void calcularTaxaOperacaoTipoDMaiorVinteCincoMilEMenorCentoVinteMilMaiorTrintaDias() {
		this.dataAgendamento.add(Calendar.DAY_OF_MONTH, 40);

		this.taxa = new OperacaoTransferenciaTipoD().calcularTaxa(50000.0,
				dataAgendamento);

		assertEquals(
				"Taxa operacoes do tipo D maior que 25.000 e menor que 120.000 e posterior a 30 dias",
				8.0, taxa, 0.01);
	}

	@Test
	public void calcularTaxaOperacaoTipoDMaiorCentoVinteMilMinimoCincoDias() {
		this.dataAgendamento.add(Calendar.DAY_OF_MONTH, 5);

		this.taxa = new OperacaoTransferenciaTipoD().calcularTaxa(150000.0,
				dataAgendamento);

		assertEquals(
				"Taxa para operacoes do tipo D maior 120.000,00 e anterior 5 dias",
				12450.0, taxa, 0.01);
	}

	@Test
	public void calcularTaxaOperacaoTipoDMaiorCentoVinteMilMinimoTrintaDias() {
		this.dataAgendamento.add(Calendar.DAY_OF_MONTH, 29);

		this.taxa = new OperacaoTransferenciaTipoD().calcularTaxa(150000.0,
				dataAgendamento);

		assertEquals(
				"Taxa para operacoes do tipo D maior 120.000,00 e anterior 30 dias",
				3150.0, taxa, 0.01);
	}

	@Test
	public void calcularTaxaOperacaoTipoDMaiorCentoVinteMilMaiorTrintaDias() {
		this.dataAgendamento.add(Calendar.DAY_OF_MONTH, 40);

		this.taxa = new OperacaoTransferenciaTipoD().calcularTaxa(150000.0,
				dataAgendamento);

		assertEquals(
				"Taxa para operacoes do tipo D maior 120.000,00 e posterior 30 dias",
				1800.0, taxa, 0.01);
	}
}
