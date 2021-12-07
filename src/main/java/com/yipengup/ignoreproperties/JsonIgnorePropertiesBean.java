package com.yipengup.ignoreproperties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yipengup.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yipengup
 * @date 2021/12/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
// 不管是序列化还是反序列化都会忽略指定的字段
@JsonIgnoreProperties(value = "name")
public class JsonIgnorePropertiesBean {

    private Integer id;
    private String name;

    public static void main(String[] args) {
        JsonIgnorePropertiesBean bean = new JsonIgnorePropertiesBean(5, "xxx");
        // {"id":5}
        System.out.println(JsonUtil.convertToString(bean));

        String jsonString = "{\"id\":5,\"name\":\"xxx\"}";
        // JsonIgnorePropertiesBean(id=5, name=null)
        System.out.println(JsonUtil.convertFromString(jsonString, JsonIgnorePropertiesBean.class));
    }

}
