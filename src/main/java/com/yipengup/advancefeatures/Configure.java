package com.yipengup.advancefeatures;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yipengup.model.Car;

/**
 * 常用配置
 *
 * @author yipengup
 * @date 2021/12/7
 */
public class Configure {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        //language=JSON
        String jsonString = "{\"id\": null, \"color\": \"yellow\", \"type\": \"Honda\", \"year\": \"1970\"}";
        // 关闭未知的属性反序列化异常
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 关闭基本数据类型对应的值为null的检查
        mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        Car car = mapper.readValue(jsonString, Car.class);
        System.out.println("car = " + car);
    }
}
