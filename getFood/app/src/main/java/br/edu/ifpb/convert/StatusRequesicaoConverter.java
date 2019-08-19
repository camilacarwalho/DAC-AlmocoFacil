package br.edu.ifpb.convert;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.domain.enums.StatusRequisicao;

@FacesConverter(forClass = StatusRequisicao.class, value="statusRequesicaoConverter")
public class StatusRequesicaoConverter implements Converter {
	
	public static String TODOS_STATUS_REQUESICAO = "Todos os status requisicao";

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty() || value.equals(TODOS_STATUS_REQUESICAO))
			return null;
		return StatusRequisicao.valueOf(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null)
			return TODOS_STATUS_REQUESICAO;
		StatusRequisicao statusRequisicao = (StatusRequisicao) value;
		return statusRequisicao.getNome();
	}
	

}
