package com.yipengup.deserialization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yipengup.util.JsonUtil;
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
public class JsonCreatorBean {

    private String id;

    private String name;

    /**
     * JsonCreator 通过标注构造器方法
     * 结合 JsonProperty 注解可以为某个属性添加反序列化对应的字段名称，（注意原字段也是可以用的）
     */
    @JsonCreator
    public JsonCreatorBean(@JsonProperty("id") String id, @JsonProperty("theName") String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        String json = "{\"id\": \"5\", \"name\": \"my bean\"}";
        // JsonCreatorBean(id=5, name=my bean)
        System.out.println(JsonUtil.convertFromString(json, JsonCreatorBean.class));

        json = "{\"id\": \"5\", \"theName\": \"my bean\"}";
        // JsonCreatorBean(id=5, name=my bean)
        System.out.println(JsonUtil.convertFromString(json, JsonCreatorBean.class));
    }
}
