package com.yipengup.deserialization.custom;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期反序列化
 *
 * @author yipengup
 * @date 2021/12/6
 */
public class CustomDateDeserializer extends StdDeserializer<Date> {

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    protected CustomDateDeserializer() {
        super((Class<?>) null);
    }

    @Override
    public Date deserialize(JsonParser p, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String date = p.getText();
        try {
            return SIMPLE_DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
