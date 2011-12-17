package br.com.bexsbanco.pojos;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BMFDOC")
public class DocPojo {

	@XStreamAlias("BMFSISMSG")
	private SisMsgPojo sisMsg = new SisMsgPojo();

	public SisMsgPojo getSisMsg() {
		return sisMsg;
	}

	public void setSisMsg(SisMsgPojo sisMsg) {
		this.sisMsg = sisMsg;
	}

	@Override
	public String toString() {
		return "DocPojo [sisMsg=" + sisMsg + "]";
	}

	
	
}
