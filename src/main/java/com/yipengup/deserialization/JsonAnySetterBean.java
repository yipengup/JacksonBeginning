package com.yipengup.deserialization;

import com.fasterxml.jackson.annotation.JsonAnySetter;
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
public class JsonAnySetterBean {

    private String id;

    /**
     * JsonAnySetter 专门处理反序列化中多余的属性
     * 一般定义一个map属性， 把多余的属性都放进map里面即可
     */
    @JsonAnySetter
    public void handleRedundantProperties(String key, String value) {
        System.out.println("key => " + key + ", value => " + value);
    }

    public static void main(String[] args) {
        String json = "{\"id\": \"5\", \"name\": \"my bean\"}";
        // key => name, value => my bean
        // ===========================================
        // JsonAnySetterBean(id=5)
        JsonAnySetterBean jsonAnySetterBean = JsonUtil.convertFromString(json, JsonAnySetterBean.class);
        System.out.println("===========================================");
        System.out.println(jsonAnySetterBean);
    }

}
