package br.com.bexsbanco.converters.consulta.lote;

import br.com.bexsbanco.pojos.DocPojo;
import br.com.bexsbanco.pojos.SisMsgPojo;
import br.com.bexsbanco.pojos.consulta.ConsultaSisMsg;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ConsultaLoteResponseConverter implements Converter{

	public boolean canConvert(Class clazz) {
		return clazz.equals(DocPojo.class);
	}

	public void marshal(Object value, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		DocPojo doc = (DocPojo) value;
		writer.startNode("BMFBCMSG");
		context.convertAnother(doc.getBcMasg());
		writer.endNode();
        writer.startNode("BMFSISMSG");
        context.convertAnother(doc.getSisMsg());
        writer.endNode();
		
	}

	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		 DocPojo doc = new DocPojo();
         reader.moveDown();
         SisMsgPojo sisMsg = (SisMsgPojo)context.convertAnother(reader, ConsultaSisMsg.class);
         doc.setSisMsg(sisMsg);
         reader.moveUp();
         return doc;
	}

}
