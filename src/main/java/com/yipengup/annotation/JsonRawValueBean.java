package com.yipengup.annotation;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.yipengup.util.JsonUtil;
import lombok.Data;

/**
 * @author yipengup
 * @date 2021/12/3
 */
@Data
public class JsonRawValueBean {
    private String id;

    /**
     * JsonRawValue 表示按原样序列化属性值，常用于本是Json的属性值原封不动的序列化输出
     */
    @JsonRawValue
    private String name;

    public static void main(String[] args) {

        JsonRawValueBean bean = new JsonRawValueBean();
        bean.setId("id");
        bean.setName("{\"attr1\": \"value1\"}");
        // {"id":"id","name":{"attr1": "value1"}}
        // 如果不带 @JsonRawValue 输出 {"id":"id","name":"{\"attr1\": \"value1\"}"}
        System.out.println(JsonUtil.convertToString(bean));

    }
}
