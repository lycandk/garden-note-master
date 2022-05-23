package com.cn.lycan.mapper;

import com.cn.lycan.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author Makkapakka
 * @date 2022-5-16
 * @package_name com.cn.lycan.mapper
 * @description
 */
@Component
@Mapper
public interface CategoryMapper {
    @Select("SELECT * FROM category")
    List<Category> findAll();

    @Select("SELECT * FROM category WHERE id = #{id}")
    Category findById(int id);
}
