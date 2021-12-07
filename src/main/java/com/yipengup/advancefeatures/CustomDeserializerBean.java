package com.yipengup.advancefeatures;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.yipengup.deserializer.CustomCarDeserializer;
import com.yipengup.model.Car;

/**
 * @author yipengup
 * @date 2021/12/7
 */
public class CustomDeserializerBean {

    public static void main(String[] args) throws JsonProcessingException {
        //language=JSON
        String jsonString = "{\"type\": \"Honda\", \"id\": 6, \"color\": \"yellow\"}";
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Car.class, new CustomCarDeserializer());
        mapper.registerModule(simpleModule);

        Car car = mapper.readValue(jsonString, Car.class);
        // car = Car(id=0, color=null, type=Honda)
        System.out.println("car = " + car);

    }
}
