package com.cn.lycan.service;

import com.cn.lycan.entity.Book;
import com.cn.lycan.entity.Category;
import com.cn.lycan.mapper.BookMapper;
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
public class BookService {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    CategoryService categoryService;

    public Book getById(int id){
        return bookMapper.getById(id);
    }

    public Book getBookByTitle(String title){
        return bookMapper.getByTitle(title);
    }

    //查出所有书籍
    public List<Book> list() {
        return bookMapper.findAll();
    }


    public void addOrUpdate(Book book) {
        if(getBookByTitle(book.getTitle()) == null){
            bookMapper.add(book);}
        else {
            bookMapper.update(book);
        }
    }

    public void deleteById(int id) {
        Book book = bookMapper.getById(id);
        if (book==null){
            System.err.println("没有查询到改id："+id+"对应书籍");
        }
        else {
            bookMapper.deleteById(id);
        }
    }

    public List<Book> search(String keywords) {
        return bookMapper.findAllByTitleLikeOrAuthorLike("%" + keywords + "%");
    }

    public List<Book> findBookByCategory(int cid) {
        Category category = categoryService.getById(cid);
        if (category!=null){
            return bookMapper.findAllByCategory(category.getId());
        }
        else {
            return bookMapper.findAll();
        }
    }

}
