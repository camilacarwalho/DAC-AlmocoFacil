package br.edu.ifpb.convert;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.cdi.ManualCDILookup;
import br.edu.ifpb.domain.Refeicao;
import br.edu.ifpb.service.RefeicaoService;

@FacesConverter(forClass = Refeicao.class, value="refeicaoConverter")
public class RefeicaoConverter extends ManualCDILookup implements Converter{

	
	public static String VALOR_DEFAULT = "Nehuma refeição";

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty() || value.equals(VALOR_DEFAULT))
			return null;
		RefeicaoService refeicaoService = null;
		try {
			refeicaoService = getFacadeWithJNDI(RefeicaoService.class);
		} catch (Exception e) {
			Logger.getLogger(RefeicaoService.class.getName()).log(Level.SEVERE,null,e);
		}
		return refeicaoService.buscarPeloNome(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null)
			return VALOR_DEFAULT;
		Refeicao refeicao  = (Refeicao) value;
		return refeicao.getNome();
	}

	



}
