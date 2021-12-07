package com.yipengup.ignoreproperties;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class JsonIgnoreBean {

    private Integer id;
    @JsonIgnore
    private String name;

    public static void main(String[] args) {
        JsonIgnoreBean bean = new JsonIgnoreBean(5, "xxx");
        // {"id":5}
        System.out.println(JsonUtil.convertToString(bean));

        String jsonString = "{\"id\":5,\"name\":\"xxx\"}";
        // JsonIgnoreBean(id=5, name=null)
        System.out.println(JsonUtil.convertFromString(jsonString, JsonIgnoreBean.class));
    }

}
