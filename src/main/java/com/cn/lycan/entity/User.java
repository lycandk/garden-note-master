package com.cn.lycan.entity;

import lombok.Data;

/**
 * @author Makkapakka
 * @date 2022-5-13
 * @package_name com.cn.lycan.entity
 * @description
 */
@Data
public class User {
    int id;
    String username;
    String password;
    String salt;
}
