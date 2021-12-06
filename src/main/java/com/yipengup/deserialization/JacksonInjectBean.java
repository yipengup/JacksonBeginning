package com.yipengup.deserialization;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yipengup
 * @date 2021/12/6
 */
@Getter
@Setter
@ToString
public class JacksonInjectBean {

    /**
     * 可以针对不再json字符串中的属性进行单独进行赋值
     */
    @JacksonInject
    private String id;
    private String name;

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"name\": \"my bean\"}";

        ObjectMapper mapper = new ObjectMapper();
        // 有点类似于prepareStatement，会逐个对具有 @JacksonInject 注解的属性进行赋值
        InjectableValues.Std std = new InjectableValues.Std();
        std.addValue(String.class, "idValue");

        // JacksonInjectBean(id=idValue, name=my bean)
        System.out.println((JacksonInjectBean) mapper
                .reader(std)
                .forType(JacksonInjectBean.class)
                .readValue(json));
    }

}
