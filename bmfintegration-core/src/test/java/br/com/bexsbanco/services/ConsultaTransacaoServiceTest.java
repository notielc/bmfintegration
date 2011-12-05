package br.com.bexsbanco.services;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
@Ignore
public class ConsultaTransacaoServiceTest {
	
	ConsultaTransacaoService consultaTransacaoService = new ConsultaTransacaoService();
	
	@Test
	public void testConsultaLote(){
		
		boolean consultaTransacao = consultaTransacaoService.consultaTransacao();
		
		Assert.assertEquals(true, consultaTransacao);
	}
}
