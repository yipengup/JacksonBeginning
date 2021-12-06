package com.yipengup.deserialization;

import com.fasterxml.jackson.annotation.JsonAlias;
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
public class JsonAliasBean {

    private String id;

    /**
     * 指定反序列化别名
     */
    @JsonAlias(value = {"name", "theName"})
    private String name;

    public static void main(String[] args) {
        String json = "{\"id\": \"5\", \"theName\": \"my bean\"}";
        // JsonAliasBean(id=5, name=my bean)
        System.out.println(JsonUtil.convertFromString(json, JsonAliasBean.class));

        json = "{\"id\": \"5\", \"name\": \"my bean\"}";
        // JsonAliasBean(id=5, name=my bean)
        System.out.println(JsonUtil.convertFromString(json, JsonAliasBean.class));
    }


}
