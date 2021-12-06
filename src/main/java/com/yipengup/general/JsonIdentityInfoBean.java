package com.yipengup.general;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yipengup.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

/**
 * JsonIdentityInfo 解决循环引用问题 使用对应的属性值表示对应的引用关系
 *
 * @author yipengup
 * @date 2021/12/6
 */
public class JsonIdentityInfoBean {

    @Getter
    @Setter
    @ToString
    @JsonIdentityInfo(property = "itemName", generator = ObjectIdGenerators.PropertyGenerator.class)
    public static class Item {
        private String id;
        private String itemName;

        private User user;
    }

    @Getter
    @Setter
    @ToString
    @JsonIdentityInfo(property = "userName", generator = ObjectIdGenerators.PropertyGenerator.class)
    public static class User {
        private String id;
        private String userName;
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

        // {"id":"itemId","itemName":"itemName","user":{"id":"userId","userName":"username","items":["itemId"]}}
        // {"itemName":"itemName","id":"itemId","user":{"userName":"username","id":"userId","items":["itemName"]}}
        System.out.println(JsonUtil.convertToString(item));
        // {"id":"userId","userName":"username","items":[{"id":"itemId","itemName":"itemName","user":"userId"}]}
        // {"userName":"username","id":"userId","items":[{"itemName":"itemName","id":"itemId","user":"username"}]}
        System.out.println(JsonUtil.convertToString(user));
    }

}
