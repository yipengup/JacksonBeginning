package com.yipengup.ignorenull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yipengup.util.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yipengup
 * @date 2021/12/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// 序列化时可以排除掉指定的字段
// @JsonInclude(value = JsonInclude.Include.NON_NULL)
public class JsonIncludeBean {

    private Integer id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    public static void main(String[] args) {
        JsonIncludeBean bean = new JsonIncludeBean();
        bean.setId(5);
        // {"id":5}
        System.out.println(JsonUtil.convertToString(bean));
    }

}
