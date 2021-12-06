package com.yipengup.general;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yipengup
 * @date 2021/12/6
 */
@JsonFilter(value = "JsonFilter")
@Getter
@Setter
@ToString
public class JsonFilterBean {
    private int id;
    private String name;

    public static void main(String[] args) throws JsonProcessingException {
        JsonFilterBean bean = new JsonFilterBean();
        bean.setId(5);
        bean.setName("xxx");

        ObjectMapper mapper = new ObjectMapper();
        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider();
        // 过滤掉不包含的属性
        simpleFilterProvider.addFilter("JsonFilter", SimpleBeanPropertyFilter.filterOutAllExcept("name"));
        mapper.setFilterProvider(simpleFilterProvider);

        // {"name":"xxx"}
        System.out.println(mapper.setFilterProvider(simpleFilterProvider).writeValueAsString(bean));
    }

}
