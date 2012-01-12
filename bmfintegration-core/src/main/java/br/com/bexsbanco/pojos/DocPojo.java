package br.com.bexsbanco.pojos;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BMFDOC")
public class DocPojo {

	@XStreamAlias("BMFSISMSG")
	private SisMsgPojo sisMsg = new SisMsgPojo();
	@XStreamAlias("BMFBCMSG")
	private BcMsgPojo bcMasg = new BcMsgPojo();

	public SisMsgPojo getSisMsg() {
		return sisMsg;
	}

	public void setSisMsg(SisMsgPojo sisMsg) {
		this.sisMsg = sisMsg;
	}
	
	public BcMsgPojo getBcMasg() {
		return bcMasg;
	}

	public void setBcMasg(BcMsgPojo bcMasg) {
		this.bcMasg = bcMasg;
	}

	@Override
	public String toString() {
		return "DocPojo [sisMsg=" + sisMsg + "]";
	}

	
	
}
