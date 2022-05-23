package com.cn.lycan.service;

import com.cn.lycan.entity.Category;
import com.cn.lycan.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Makkapakka
 * @date 2022-5-16
 * @package_name com.cn.lycan.service
 * @description
 */
@Component
@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;


    public List<Category> list(){
        return categoryMapper.findAll();
    }

    public Category getById(int id){
        return categoryMapper.findById(id);

    }

}
