package br.edu.ifpb.convert;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.domain.Refeicao;
import br.edu.ifpb.service.RefeicaoService;

@Stateless
@FacesConverter(forClass = Refeicao.class, value="refeicaoConverter")
public class RefeicaoConverter implements Converter{
	
	@EJB
	RefeicaoService refeicaoService;
	
	public static String VALOR_DEFAULT = "Nehuma refeição";

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty() || value.equals(VALOR_DEFAULT))
			return null;
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
