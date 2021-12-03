package com.yipengup.annotation;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Map;

/**
 * JsonAnyGet 注解
 * <p>
 * 可以将map中的键值对作为属性和属性值序列化
 *
 * @author yipengup
 * @date 2021/12/3
 */

@Getter
@Setter
public class JsonAnyGetBean {

    private String name;

    @JsonAnyGetter
    private Map<String, String> map;

    public static void main(String[] args) throws JsonProcessingException {
        JsonAnyGetBean jsonAnyGetBean = new JsonAnyGetBean();
        jsonAnyGetBean.setName(JsonAnyGetBean.class.getName());
        jsonAnyGetBean.setMap(Collections.singletonMap("xi", "ha"));

        String result = new ObjectMapper().writeValueAsString(jsonAnyGetBean);
        // {"name":"com.yipengup.annotation.JsonAnyGetBean","map":{"xi":"ha"},"xi":"ha"}
        System.out.println("result = " + result);
    }

}
