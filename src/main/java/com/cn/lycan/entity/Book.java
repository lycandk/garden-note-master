package com.cn.lycan.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author Makkapakka
 * @date 2022-5-16
 * @package_name com.cn.lycan.entity
 * @description
 */
@Data
public class Book {
    int id;
    private Category category;
    String cover;
    String title;
    String author;
    String date;
    String press;
    String abs;


}
