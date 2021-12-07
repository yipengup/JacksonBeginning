package com.yipengup.advancefeatures;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yipengup.model.Honda;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yipengup
 * @date 2021/12/7
 */
public class DateFormatBean {

    public static void main(String[] args) throws Exception {

        Honda honda = new Honda();
        honda.setId(2);
        honda.setColor("yellow");
        honda.setType("honda");
        honda.setDatePurchased(new Date());

        ObjectMapper mapper = new ObjectMapper();
        // {"id":2,"color":"yellow","type":"honda","datePurchased":1638867110967}
        System.out.println(mapper.writeValueAsString(honda));

        // 设置时间格式化
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
        // {"id":2,"color":"yellow","type":"honda","datePurchased":"2021-12-07 04:53:29"}
        System.out.println(mapper.writeValueAsString(honda));


    }
}
