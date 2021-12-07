package com.yipengup.mixin;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yipengup.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yipengup
 * @date 2021/12/7
 */
public class JsonMixinBean {

    @Getter
    @Setter
    @ToString
    public static class User {
        private String username;
        private String id;
    }

    @Getter
    @Setter
    @ToString
    @JsonPropertyOrder(alphabetic = true)
    public static class Item {
        private User user;
        private Integer id;
        private String name;
    }

    /**
     * JsonIgnoreType 对对象作为属性时，序列化会忽略掉当前的属性
     */
    @Getter
    @Setter
    @ToString
    // @JsonIgnoreType
    @JsonPropertyOrder(alphabetic = true)
    public static class Mixin {
    }

    public static void main(String[] args) throws JsonProcessingException {
        Item item = new Item();
        item.setId(5);
        item.setName("xxx");

        // {"id":5,"name":"xxx","user":null}
        System.out.println(JsonUtil.convertToString(item));

        ObjectMapper objectMapper = new ObjectMapper();
        // 相当于把Mixin的注解添加到User类上
        objectMapper.addMixIn(User.class, Mixin.class);
        // 当用 JsonIgnoreType注解修饰 Mixin类时 {"id":5,"name":"xxx"}
        System.out.println(objectMapper.writeValueAsString(item));

        User user = new User();
        user.setId("5");
        user.setUsername("username");
        item.setUser(user);
        // 当使用 JsonPropertyOrder注解修饰 Mixin类时 {"id":5,"name":"xxx","user":{"id":"5","username":"username"}}
        System.out.println(objectMapper.writeValueAsString(item));

    }


}
