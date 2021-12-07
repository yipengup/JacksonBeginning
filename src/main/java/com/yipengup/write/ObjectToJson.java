package com.yipengup.write;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yipengup.model.Car;

import java.io.File;
import java.util.Arrays;

/**
 * 将对象转化成字符串的常用方法
 *
 * @author yipengup
 * @date 2021/12/7
 */
public class ObjectToJson {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Car car = new Car("yellow", "Honda");
        // 将序列化结果输出到文件中
        mapper.writeValue(new File("D:\\Projects\\Java\\JacksonBeginning\\src\\main\\java\\com\\yipengup\\write\\Temp.txt"), car);
        // 将序列化结果以字符串输出
        System.out.println(mapper.writeValueAsString(car));
        // 将序列化结果以字节数组输出
        byte[] bytes = mapper.writeValueAsBytes(car);
        System.out.println("bytes = " + Arrays.toString(bytes));
    }
}
