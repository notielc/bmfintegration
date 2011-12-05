package br.com.bexsbanco.pojos.consulta.extrato;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("BBMFConsMovtoConta")
public class ConsultaExtratoRequest {

	@XStreamAlias("id")
	@XStreamAsAttribute
	private String id;
	@XStreamAlias("Movto")
	private Movimento movimento;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Movimento getMovimento() {
		return movimento;
	}

	public void setMovimento(Movimento movimento) {
		this.movimento = movimento;
	}

	@Override
	public String toString() {
		return "ConsultaExtratoRequest [id=" + id + ", movimento=" + movimento.toString() + ", toString()="
				+ super.toString() + "]";
	}

}
