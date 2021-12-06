package com.yipengup.general;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yipengup.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

/**
 * 解决循环依赖的问题， JsonManagedReference 父引用，  JsonBackReference  子引用
 * 最后会输出 JsonManagedReference 对应的属性， 忽略掉 JsonBackReference 对应的属性
 *
 * @author yipengup
 * @date 2021/12/6
 */
public class JsonManagedReferenceAndJsonBackReferenceBean {

    @Getter
    @Setter
    @ToString
    public static class Item {
        private String id;
        private String itemName;

        // @JsonManagedReference
        @JsonBackReference
        private User user;
    }

    @Getter
    @Setter
    @ToString
    public static class User {
        private String id;
        private String userName;

        // @JsonBackReference
        @JsonManagedReference
        private List<Item> items;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setId("userId");
        user.setUserName("username");

        Item item = new Item();
        item.setId("itemId");
        item.setItemName("itemName");
        item.setUser(user);

        List<Item> items = Collections.singletonList(item);
        user.setItems(items);

        // {"id":"itemId","itemName":"itemName","user":{"id":"userId","userName":"username"}}
        System.out.println(JsonUtil.convertToString(item));

        // {"id":"userId","userName":"username"}
        System.out.println(JsonUtil.convertToString(user));

    }


}
