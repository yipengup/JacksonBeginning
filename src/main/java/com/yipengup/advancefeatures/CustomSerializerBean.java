package com.yipengup.advancefeatures;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.yipengup.model.Car;
import com.yipengup.serializer.CustomCarSerializer;

/**
 * @author yipengup
 * @date 2021/12/7
 */
public class CustomSerializerBean {

    public static void main(String[] args) throws Exception {
        Car car = new Car(5, "yellow", "Honda");
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        // 添加序列化器
        module.addSerializer(Car.class, new CustomCarSerializer());
        // 注册组件
        mapper.registerModule(module);
        // {"car_type":"Honda"}
        System.out.println(mapper.writeValueAsString(car));
    }
}
