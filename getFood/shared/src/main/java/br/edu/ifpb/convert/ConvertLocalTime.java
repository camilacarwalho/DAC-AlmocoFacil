package br.edu.ifpb.convert;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ConvertLocalTime implements AttributeConverter<LocalTime, Time> {

	@Override
	public Time convertToDatabaseColumn(LocalTime localTime) {
		if (localTime == null)
			return null;
		return Time.valueOf(localTime);
	}

	@Override
	public LocalTime convertToEntityAttribute(Time time) {
		if (time == null)
			return null;
		return time.toLocalTime();
	}
	

}
