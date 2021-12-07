package com.yipengup.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.yipengup.model.Car;

import java.io.IOException;

/**
 * @author yipengup
 * @date 2021/12/7
 */
public class CustomCarDeserializer extends StdDeserializer<Car> {

    public CustomCarDeserializer() {
        super((Class<?>) null);
    }

    @Override
    public Car deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        Car car = new Car();
        // ObjectMapper的超类
        ObjectCodec codec = p.getCodec();
        JsonNode treeNode = codec.readTree(p);
        String type = treeNode.get("type").asText();
        car.setType(type);
        return car;
    }
}
