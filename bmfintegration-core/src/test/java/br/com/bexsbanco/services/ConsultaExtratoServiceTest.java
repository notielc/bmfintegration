package br.com.bexsbanco.services;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
@Ignore
public class ConsultaExtratoServiceTest {
	
	ConsultaExtratoService consultaExtratoService = new ConsultaExtratoService();
	
	@Test
	public void testConsultaLote(){
		
		boolean consultaExtrato = consultaExtratoService.consultaExtrato();
		
		Assert.assertEquals(true, consultaExtrato);
	}
}
