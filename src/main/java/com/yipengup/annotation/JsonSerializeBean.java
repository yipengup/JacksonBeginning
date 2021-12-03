package com.yipengup.annotation;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.yipengup.annotation.customizer.CustomDateSerializer;
import com.yipengup.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author yipengup
 * @date 2021/12/3
 */
@Getter
@Setter
public class JsonSerializeBean {

    private String id;
    private String name;
    /**
     * 自定义序列化方式
     */
    @JsonSerialize(using = CustomDateSerializer.class)
    private Date date;

    public static void main(String[] args) {
        JsonSerializeBean bean = new JsonSerializeBean();
        bean.setId("id");
        bean.setName("name");
        bean.setDate(new Date());
        // {"id":"id","name":"name","date":"2021-12-03 06:49:48"}
        System.out.println(JsonUtil.convertToString(bean));
    }

}
