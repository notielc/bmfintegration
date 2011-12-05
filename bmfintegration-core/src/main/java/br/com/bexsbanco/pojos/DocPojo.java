package br.com.bexsbanco.pojos;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BMFDOC")
public class DocPojo {

	@XStreamAlias("BMFBCMSG")
	private BcMsgPojo bcMasg = new BcMsgPojo();
	@XStreamAlias("BMFSISMSG")
	private SisMsgPojo sisMsg = new SisMsgPojo();

	public BcMsgPojo getBcMasg() {
		return bcMasg;
	}

	public void setBcMasg(BcMsgPojo bcMasg) {
		this.bcMasg = bcMasg;
	}

	public SisMsgPojo getSisMsg() {
		return sisMsg;
	}

	public void setSisMsg(SisMsgPojo sisMsg) {
		this.sisMsg = sisMsg;
	}

	@Override
	public String toString() {
		return "DocPojo [bcMasg=" + bcMasg + ", sisMsg=" + sisMsg + "]";
	}

	
	
}
