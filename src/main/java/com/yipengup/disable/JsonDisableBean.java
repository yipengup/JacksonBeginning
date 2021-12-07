package com.yipengup.disable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yipengup
 * @date 2021/12/7
 */
@Getter
@Setter
@ToString
@JsonPropertyOrder(alphabetic = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class JsonDisableBean {

    private String name;
    private Integer id;

    public static void main(String[] args) throws JsonProcessingException {
        JsonDisableBean bean = new JsonDisableBean();
        bean.setId(5);

        JsonMapper jsonMapper = JsonMapper.builder().disable(MapperFeature.USE_ANNOTATIONS).build();
        // {"name":null,"id":5}
        System.out.println(jsonMapper.writeValueAsString(bean));

        ObjectMapper objectMapper = new ObjectMapper();
        // {"name":null,"id":5}
        objectMapper.disable(MapperFeature.USE_ANNOTATIONS);
        System.out.println(objectMapper.writeValueAsString(bean));
    }

}
