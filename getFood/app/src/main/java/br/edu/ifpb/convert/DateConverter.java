package br.edu.ifpb.convert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("dateConverter")
public class DateConverter  implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String date) {
		if (date.isEmpty())
			return null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
		LocalDate localDate = LocalDate.parse(date,formatter);
		return localDate;
		}catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null)
			return "";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data = ((LocalDate) value).format(formatter);
		return data;
	}

}
