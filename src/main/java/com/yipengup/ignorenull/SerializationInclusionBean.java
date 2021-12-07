package com.yipengup.ignorenull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class SerializationInclusionBean {

    private Integer id;
    private String name;

    public static void main(String[] args) throws JsonProcessingException {

        SerializationInclusionBean bean = new SerializationInclusionBean();
        bean.setId(5);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        System.out.println(mapper.writeValueAsString(bean));
    }
}
