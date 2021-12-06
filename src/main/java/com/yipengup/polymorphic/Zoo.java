package com.yipengup.polymorphic;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
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
public class Zoo {

    private Animal animal;

    @Getter
    @Setter
    @ToString
    // 指定以属性名为type的方式打印子类的详细信息
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
    // 指定子类列表
    @JsonSubTypes(value = {
            @JsonSubTypes.Type(value = Dog.class)
    })
    public static class Animal {
        private String name;
    }

    @Getter
    @Setter
    @ToString
    /**
     * 在 @JsonSubTypes.Type 没有指定 name属性时，就会以当前指定的名称为主
     */
    @JsonTypeName("JsonTypeName_Dog")
    public static class Dog extends Animal {
        private String barkVolume;
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        Dog dog = new Dog();
        dog.setName("旺财");
        dog.setBarkVolume("汪汪汪");
        zoo.setAnimal(dog);
        // 没有添加多态性注解：{"animal":{"name":"旺财","barkVolume":"汪汪汪"}}
        // 添加了多态性注解后：{"animal":{"type":"JsonTypeName_Dog","name":"旺财","barkVolume":"汪汪汪"}}
        System.out.println(JsonUtil.convertToString(zoo));

        String json = "{\"animal\":{\"type\":\"JsonTypeName_Dog\",\"name\":\"旺财\"}}";
        // 可以反序列化到指定的子类
        // Zoo(animal=Zoo.Dog(barkVolume=null))
        System.out.println(JsonUtil.convertFromString(json, Zoo.class));
    }


}
