package br.com.bexsbanco.pojos.consulta.lote;

import java.util.List;

import br.com.bexsbanco.pojos.consulta.transacao.Transacao;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("LoteTransacao")
public class LoteTransacao {

	@XStreamAlias("ID")
	@XStreamAsAttribute
	private String id;
	@XStreamImplicit
	private List<Transacao> transacaoLote;
	
	
	public List<Transacao> getTransacaoLote() {
		return transacaoLote;
	}
	public void setTransacaoLote(List<Transacao> transacao) {
		this.transacaoLote = transacao;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "LoteTransacao [id=" + id + ", transacao=" + transacaoLote + "]";
	}
	
	
}
