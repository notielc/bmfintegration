package br.com.bexsbanco.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import br.com.bexsbanco.pojos.consulta.ErrorMessage;

public class ErrorMessageDAOTest {

	@Test
	public void testSave() throws Exception {
		
		ErrorMessage errorMessage = new ErrorMessage();
		
		errorMessage.setNameReq("requisicao");
		errorMessage.setErrorId("12");
		errorMessage.setDate(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
		
		ErrorMessageDAO dao = new ErrorMessageDAO();
		dao.saveErrorMessage("testErrorMessage", errorMessage);
	}
}
