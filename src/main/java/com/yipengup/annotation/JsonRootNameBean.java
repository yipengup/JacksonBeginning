package com.yipengup.annotation;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Getter;
import lombok.Setter;

/**
 * JsonRootName 将序列化的结果用指定的value封装成json
 *
 * @author yipengup
 * @date 2021/12/3
 */
@Getter
@Setter
@JsonRootName(value = "user")
public class JsonRootNameBean {
    private String id;
    private String name;

    public static void main(String[] args) throws JsonProcessingException {
        JsonRootNameBean bean = new JsonRootNameBean();
        bean.setId("id");
        bean.setName("name");
        ObjectMapper mapper = new ObjectMapper();
        // 需要开启根目录包装
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        // {"user":{"id":"id","name":"name"}}
        System.out.println(mapper.writeValueAsString(bean));
    }
}
