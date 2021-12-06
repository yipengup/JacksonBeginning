package com.yipengup.general;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.yipengup.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yipengup
 * @date 2021/12/6
 */
@Getter
@Setter
@ToString
public class JsonUnwrappedBean {

    @JsonUnwrapped
    private Name name;

    @Getter
    @Setter
    @ToString
    public static class Name {
        private String firstName;
        private String lastName;
    }

    public static void main(String[] args) {
        Name name = new Name();
        name.setFirstName("firstName");
        name.setLastName("lastName");
        JsonUnwrappedBean bean = new JsonUnwrappedBean();
        bean.setName(name);

        // {"firstName":"firstName","lastName":"lastName"}
        System.out.println(JsonUtil.convertToString(bean));

        // JsonUnwrappedBean(name=JsonUnwrappedBean.Name(firstName=firstName, lastName=lastName))
        System.out.println(JsonUtil.convertFromString("{\"firstName\":\"firstName\",\"lastName\":\"lastName\"}", JsonUnwrappedBean.class));
    }


}
