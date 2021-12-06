package com.yipengup.deserialization;

import com.fasterxml.jackson.annotation.JsonSetter;
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
public class JsonSetterBean {

    private String id;
    private String theName;

    /**
     * 为某个属性重新定义set方法
     * 这里JsonSetter中的value表示的Json字符串中的key
     */
    @JsonSetter("name")
    public void setName(String name) {
        this.theName = name;
    }

    public static void main(String[] args) {
        String json = "{\"id\": \"5\", \"name\": \"my bean\"}";
        // JsonSetterBean(id=5, theName=my bean)
        System.out.println(JsonUtil.convertFromString(json, JsonSetterBean.class));
    }

}
