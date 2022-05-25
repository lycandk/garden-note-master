package com.cn.lycan.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author Makkapakka
 * @date 2022-5-13
 * @package_name com.cn.lycan.entity
 * @description
 */
@Data
@ToString
public class User {
    int id;
    String username;
    String password;
    String salt;
}
