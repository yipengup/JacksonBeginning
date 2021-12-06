package com.yipengup.customannotation;

import com.yipengup.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yipengup
 * @date 2021/12/6
 */
@CustomAnnotation
@Getter
@Setter
@ToString
public class CustomAnnotationBean {

    private Integer id;
    private String name;

    public static void main(String[] args) {

        CustomAnnotationBean customAnnotationBean = new CustomAnnotationBean();
        customAnnotationBean.setId(5);
        // customAnnotationBean.setName("xxx");

        // {"id":5}
        System.out.println(JsonUtil.convertToString(customAnnotationBean));
    }

}
