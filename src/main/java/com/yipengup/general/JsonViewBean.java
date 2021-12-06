package com.yipengup.general;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class JsonViewBean {

    @JsonView(value = {Public.class})
    private String id;
    @JsonView(value = {Public.class})
    private String name;
    @JsonView(value = {Internal.class})
    private String sex;

    public static void main(String[] args) throws JsonProcessingException {
        JsonViewBean bean = new JsonViewBean();
        bean.setId("5");
        bean.setName("xxx");
        bean.setSex("男");

        ObjectMapper objectMapper = new ObjectMapper();
        // {"id":"5","name":"xxx"} 只会输出对应的视图的所关联的属性
        System.out.println(objectMapper.writerWithView(Public.class).writeValueAsString(bean));
    }


    public static class Public {
    }

    public static class Internal extends Public {
    }


}
