package com.yipengup.general;

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
public class JsonPropertyBean {

    // @JsonProperty("theName")
    private String name;

    // @JsonGetter(value = "theName")
    @JsonProperty("theName")
    public String getName() {
        return name;
    }

    // @JsonSetter(value = "theName")
    @JsonProperty("theName")
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        JsonPropertyBean bean = new JsonPropertyBean();
        bean.setName("xxx");
        // {"theName":"xxx"}
        System.out.println(JsonUtil.convertToString(bean));

        String json = "{\"theName\":\"xxx\"}";
        JsonPropertyBean propertyBean = JsonUtil.convertFromString(json, JsonPropertyBean.class);
        // JsonPropertyBean(name=xxx)
        System.out.println(propertyBean);
    }


}
