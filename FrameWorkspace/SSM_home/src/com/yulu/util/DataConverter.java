package com.yulu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义日期转换器（SpringMVC中的日期转换器）
 * S表示原始类型，T表示需要转换的类型
 *
 */
public class DataConverter implements Converter<String,Date>{

	@Override
	public Date convert(String str) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		try {
			return dateFormat.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
