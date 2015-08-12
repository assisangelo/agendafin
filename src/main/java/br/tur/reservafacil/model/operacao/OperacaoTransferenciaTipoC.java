package br.tur.reservafacil.model.operacao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.tur.reservafacil.model.taxa.TaxaMaisDeTrintaDias;
import br.tur.reservafacil.model.taxa.TaxaMinimoCincoDias;
import br.tur.reservafacil.model.taxa.TaxaMinimoDezDias;
import br.tur.reservafacil.model.taxa.TaxaMinimoQuinzeDias;
import br.tur.reservafacil.model.taxa.TaxaMinimoTrintaDias;
import br.tur.reservafacil.model.taxa.TaxaMinimoVinteCincoDias;
import br.tur.reservafacil.model.taxa.TaxaMinimoVinteDias;

public class OperacaoTransferenciaTipoC implements TipoOperacaoTransferencia {

	public double calcularTaxa(double valor, Calendar dataAgendamento) {
		Calendar dataReferencia = Calendar.getInstance();
		
		int diferencaEmDias = (int) ((dataAgendamento.getTime().getTime() - dataReferencia.getTime().getTime()) / (1000 * 60 * 60 * 24));
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(format.format(dataAgendamento.getTime().getTime()));
		System.out.println(format.format(dataReferencia.getTime().getTime()));
		
		TaxaMinimoCincoDias taxaMinimoCincoDias = new TaxaMinimoCincoDias();
		TaxaMinimoDezDias taxaMinimoDezDias = new TaxaMinimoDezDias();
		TaxaMinimoQuinzeDias taxaMinimoQuinzeDias = new TaxaMinimoQuinzeDias();
		TaxaMinimoVinteDias taxaMinimoVinteDias = new TaxaMinimoVinteDias();
		TaxaMinimoVinteCincoDias taxaMinimoVinteCincoDias = new TaxaMinimoVinteCincoDias();
		TaxaMinimoTrintaDias taxaMinimoTrintaDias = new TaxaMinimoTrintaDias();
		TaxaMaisDeTrintaDias taxaMaisDeTrintaDias = new TaxaMaisDeTrintaDias();
		
		
		taxaMinimoCincoDias.proximoCalculo(taxaMinimoDezDias);
		taxaMinimoDezDias.proximoCalculo(taxaMinimoQuinzeDias);
		taxaMinimoQuinzeDias.proximoCalculo(taxaMinimoVinteDias);
		taxaMinimoVinteDias.proximoCalculo(taxaMinimoVinteCincoDias);
		taxaMinimoVinteCincoDias.proximoCalculo(taxaMinimoTrintaDias);
		taxaMinimoTrintaDias.proximoCalculo(taxaMaisDeTrintaDias);
		
		return taxaMinimoCincoDias.valorTaxa(valor, diferencaEmDias);
	}

}
