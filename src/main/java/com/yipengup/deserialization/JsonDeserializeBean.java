package com.yipengup.deserialization;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.yipengup.deserialization.custom.CustomDateDeserializer;
import com.yipengup.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author yipengup
 * @date 2021/12/6
 */
@Getter
@Setter
@ToString
public class JsonDeserializeBean {

    private String id;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date date;

    public static void main(String[] args) {
        String json = "{\"id\": \"5\", \"date\": \"2021-12-06 08:00:00\"}";
        // JsonDeserializeBean(id=5, date=Mon Dec 06 08:00:00 CST 2021)
        System.out.println(JsonUtil.convertFromString(json, JsonDeserializeBean.class));
    }
}
