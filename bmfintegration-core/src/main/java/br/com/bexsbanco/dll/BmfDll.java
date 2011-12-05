package br.com.bexsbanco.dll;

import com.sun.jna.Library;

public interface BmfDll extends Library {
	
	public Integer BBMFSign(String xmlSign, String inTag, byte[] outXML);
	public Integer BBMFSignEx(String xmlSign, String inTag, byte[] outXML);
	public Integer BBMFVerify(String inXML, String inTag);


}
