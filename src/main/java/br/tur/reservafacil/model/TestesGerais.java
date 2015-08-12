package br.tur.reservafacil.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestesGerais {
public static void main(String[] args) {
	Calendar hoje = Calendar.getInstance();
	hoje.add(Calendar.DAY_OF_MONTH, 30);
	
	Calendar ref = Calendar.getInstance();
	ref.set(2015, 8, 10);
	
	if(ref.before(hoje)){
		System.out.println("Inclui");
	} else{
		System.out.println("exclui");
	}
	
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	
	System.out.println(format.format(hoje.getTime()));
}
}
