package com.yipengup.annotation;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.yipengup.util.JsonUtil;
import lombok.Data;

/**
 * JsonGetter 重新指定属性的getter方法
 *
 * @author yipengup
 * @date 2021/12/3
 */
@Data
public class JsonGetterBean {

    private String id;

    private String name;

    @JsonGetter("name")
    public String getTheName() {
        return name + "_JsonGetter";
    }

    public static void main(String[] args) {
        JsonGetterBean jsonGetterBean = new JsonGetterBean();
        jsonGetterBean.setId("123");
        jsonGetterBean.setName("张三");
        // {"id":"123","name":"张三_JsonGetter"}
        System.out.println(JsonUtil.convertToString(jsonGetterBean));
    }


}
