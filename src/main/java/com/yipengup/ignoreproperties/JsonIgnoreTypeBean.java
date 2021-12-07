package com.yipengup.ignoreproperties;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.yipengup.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yipengup
 * @date 2021/12/7
 */
// 表示忽略掉所有的属性（常用来与MixIn混入注解联用达到将某个类的清除）
@JsonIgnoreType
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonIgnoreTypeBean {

    private Integer id;
    private String name;

    public static void main(String[] args) {
        JsonIgnoreTypeBean bean = new JsonIgnoreTypeBean(5, "xxx");
        // {"id":5}
        System.out.println(JsonUtil.convertToString(bean));

        String jsonString = "{\"id\":5,\"name\":\"xxx\"}";
        // JsonIgnoreTypeBean(id=5, name=xxx)
        // note：JsonIgnoreType只针对序列化，反序列化不起作用
        System.out.println(JsonUtil.convertFromString(jsonString, JsonIgnoreTypeBean.class));
    }
}
