package com.yipengup.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.yipengup.model.Car;

import java.io.IOException;

/**
 * 自定义序列化
 *
 * @author yipengup
 * @date 2021/12/7
 */
public class CustomCarSerializer extends StdSerializer<Car> {

    public CustomCarSerializer() {
        super((Class<Car>) null);
    }

    @Override
    public void serialize(Car value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
        // 这里我们只需要展示car的类型
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("car_type", value.getType());
        jsonGenerator.writeEndObject();
    }
}
