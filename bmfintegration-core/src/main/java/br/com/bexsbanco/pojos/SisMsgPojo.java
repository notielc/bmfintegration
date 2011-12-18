package br.com.bexsbanco.pojos;

import br.com.bexsbanco.pojos.consulta.ErrorMessage;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BMFSISMSG")
public class SisMsgPojo {

	@XStreamAlias("BMFBCMSG")
	private BcMsgPojo bcMasg = new BcMsgPojo();
	@XStreamAlias("ErrorMessage")
	private ErrorMessage errorMessage;
	
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	public BcMsgPojo getBcMasg() {
		return bcMasg;
	}

	public void setBcMasg(BcMsgPojo bcMasg) {
		this.bcMasg = bcMasg;
	}
	
	
}
