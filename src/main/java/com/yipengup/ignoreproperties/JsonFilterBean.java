package com.yipengup.ignoreproperties;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yipengup
 * @date 2021/12/7
 */
@JsonFilter(value = "myFilter")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonFilterBean {

    private Integer id;
    private String name;

    public static void main(String[] args) throws Exception {
        JsonFilterBean bean = new JsonFilterBean(5, "xxx");

        ObjectMapper mapper = new ObjectMapper();
        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        // 序列化所有字段， 排除指定的字段
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAllExcept("name");
        filterProvider.addFilter("myFilter", simpleBeanPropertyFilter);
        mapper.setFilterProvider(filterProvider);
        // {"id":5}
        System.out.println(mapper.writeValueAsString(bean));

        String jsonString = "{\"id\":5,\"name\":\"xxx\"}";
        // 这里设置的过滤器只对序列化有效
        // JsonFilterBean(id=5, name=xxx)
        System.out.println(mapper.readValue(jsonString, JsonFilterBean.class));
    }
}
