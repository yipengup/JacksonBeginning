package com.yipengup.read;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yipengup.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 将json反序列化成对象
 *
 * @author yipengup
 * @date 2021/12/7
 */
public class JsonToObject {

    public static void main(String[] args) throws Exception {
        String json = "{\"color\":\"yellow\",\"type\":\"Honda\"}";

        ObjectMapper mapper = new ObjectMapper();
        // 当前数据来源可以是任意的数据流（网络、文件等）
        // car = Car(color=yellow, type=Honda)
        Car car = mapper.readValue(json, Car.class);
        System.out.println("car = " + car);

        JsonNode jsonNode = mapper.readTree(json);
        // jsonNode = {"color":"yellow","type":"Honda"}
        System.out.println("jsonNode = " + jsonNode);

        Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });
        // map = {color=yellow, type=Honda}
        System.out.println("map = " + map);

        String jsonArray = "[{\"color\":\"yellow\",\"type\":\"Honda\"}, {\"color\":\"yellow\",\"type\":\"Honda\"}]";
        List<Car> carList = mapper.readValue(jsonArray, new TypeReference<List<Car>>() {
        });
        // carList = [Car(color=yellow, type=Honda), Car(color=yellow, type=Honda)]
        System.out.println("carList = " + carList);

        Car[] cars = mapper.readValue(jsonArray, Car[].class);
        // cars = [Car(color=yellow, type=Honda), Car(color=yellow, type=Honda)]
        System.out.println("cars = " + Arrays.toString(cars));


    }
}
