package com.yipengup.model;

import lombok.*;

import java.util.Date;

/**
 * @author yipengup
 * @date 2021/12/7
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Honda extends Car {
    private Date datePurchased;
}
