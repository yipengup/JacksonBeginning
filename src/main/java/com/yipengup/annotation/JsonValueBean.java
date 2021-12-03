package com.yipengup.annotation;

import com.fasterxml.jackson.annotation.JsonValue;
import com.yipengup.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yipengup
 * @date 2021/12/3
 */
@Getter
@Setter
public class JsonValueBean {

    private String id;

    /**
     * JsonValue 用该属性值代替整个对象的序列化值（可以用枚举类）
     */
    @JsonValue
    private String name;

    public static void main(String[] args) {
        JsonValueBean bean = new JsonValueBean();
        bean.setId("id");
        bean.setName("name");
        // "name"
        System.out.println(JsonUtil.convertToString(bean));
    }


}
