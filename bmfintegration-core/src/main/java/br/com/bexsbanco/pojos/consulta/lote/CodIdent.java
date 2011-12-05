package br.com.bexsbanco.pojos.consulta.lote;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("CodIdent")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"value"})
public class CodIdent {
	
	@XStreamAlias("Situacao")
	@XStreamAsAttribute
	private String situacao;
	private String value;

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CodIdent [situacao=" + situacao + ", value=" + value + "]";
	}

	
	
}
