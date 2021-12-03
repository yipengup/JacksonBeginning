package com.yipengup.annotation;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.yipengup.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yipengup
 * @date 2021/12/3
 */
// 指定字段的序列化顺序（默认按照定义的顺序进行序列化）
// 指定的字段会优先序列化， 未指定的字段再按照字母顺序序列化（如果未指定alphabetic则按照定义的顺序）
@JsonPropertyOrder(value = {"sex", "name"}, alphabetic = true)
@Data
@AllArgsConstructor
public class JsonPropertyOrderBean {

    private String id;
    private String name;
    private String sex;
    private String a;

    public static void main(String[] args) {
        JsonPropertyOrderBean orderBean = new JsonPropertyOrderBean("id", "name", "sex", "a");
        // {"sex":"sex","name":"name","a":"a","id":"id"}
        System.out.println(JsonUtil.convertToString(orderBean));
    }

}
