package com.cn.lycan.mapper;

import com.cn.lycan.entity.Book;
import com.cn.lycan.entity.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Makkapakka
 * @date 2022-5-16
 * @package_name com.cn.lycan.mapper
 * @description当前未解决问题：1按照id查询数据报id错误；
 */
@Component
@Mapper
public interface BookMapper {

    @Select("SELECT * FROM book WHERE cid = #{cid}")
    @Result(column = "cid" , property = "category",javaType = Category.class, one = @One(select = "com.cn.lycan.mapper." +
            "CategoryMapper.findById"))
    List<Book> findAllByCategory(int cid);
    @Select("SELECT * FROM book WHERE title LIKE #{keyword} OR author LIKE #{keyword}")
    List<Book> findAllByTitleLikeOrAuthorLike( String keyword);

    //查询所有数据
    @Select("SELECT * FROM book")
    @Result(column = "cid" , property = "category",javaType = Category.class, one = @One(select = "com.cn.lycan.mapper." +
            "CategoryMapper.findById"))
    List<Book> findAll();

    @Insert("INSERT INTO book (cover,title,author,date,press,abs,cid) VALUES (#{cover}, #{title},#{author}," +
            "#{date},#{press},#{abs},#{category.id})")
    int add(Book book);


    @Update("UPDATE book SET cover = #{cover},title=#{title},author=#{author}"+
            ",date = #{date},press =#{press},abs=#{abs},cid=#{category.id} WHERE id=#{id}")
    int update(Book book);


    @Delete("DELETE FROM book WHERE id = #{id}")
    void deleteById(int id);

    //查询调用时id报null
    @Select("SELECT * FROM book WHERE id = #{id}")
    Book getById(int id);



    @Select("SELECT * FROM book WHERE title = #{title}")
    Book getByTitle(String title);
}
