package br.com.bexsbanco.services;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ConsultaLoteServiceTest {
	
	ConsultaLoteService consultaLoteService = new ConsultaLoteService();
	
	@Test
	public void testConsultaLote(){
		
		boolean consultaLote = consultaLoteService.consultaLote();
		
		Assert.assertEquals(true, consultaLote);
	}
}
