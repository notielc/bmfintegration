package br.com.bexsbanco.pojos;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BMFSISMSG")
public class SisMsgPojo {

	@XStreamAlias("BMFBCMSG")
	private BcMsgPojo bcMasg = new BcMsgPojo();

	public BcMsgPojo getBcMasg() {
		return bcMasg;
	}

	public void setBcMasg(BcMsgPojo bcMasg) {
		this.bcMasg = bcMasg;
	}
	
	
}
