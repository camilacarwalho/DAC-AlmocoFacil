package br.edu.ifpb.convert;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("timeConverter")
public class TimerConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.isEmpty())			
			return null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		try {
			LocalTime localTime = LocalTime.parse(value,formatter);
			return localTime;
		}catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null)
			return "";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		String hora = ((LocalTime) value).format(formatter);
		return hora;
	}
}
