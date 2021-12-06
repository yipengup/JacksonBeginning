package com.yipengup.general;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class JsonFormatBean {

    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Date date;

    public static void main(String[] args) {
        JsonFormatBean bean = new JsonFormatBean();
        bean.setDate(new Date());

        // {"date":"2021-12-06 11:02:59"}
        // 毫秒时间戳 {"date":1638791899945}
        System.out.println(JsonUtil.convertToString(bean));

        // JsonFormatBean(date=Mon Dec 06 19:58:19 CST 2021)
        System.out.println(JsonUtil.convertFromString("{\"date\":1638791899945}", JsonFormatBean.class));
    }

}
