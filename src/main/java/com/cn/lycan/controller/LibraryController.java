package com.cn.lycan.controller;

import com.cn.lycan.entity.Book;
import com.cn.lycan.entity.Category;
import com.cn.lycan.service.BookService;
import com.cn.lycan.service.CategoryService;
import com.cn.lycan.utils.StringUtils;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Makkapakka
 * @date 2022-5-16
 * @package_name com.cn.lycan.controller
 * @description
 */
@RestController
@CrossOrigin
public class LibraryController {
    @Autowired
    BookService bookService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/api/books")
    public List<Book> books() throws Exception {
        return bookService.list();
    }

    @PostMapping("/api/books")
    public Book addOrUpdateBook(@RequestBody Book book)throws Exception{
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    public void deleteBook(@RequestBody Book book)throws Exception{
        bookService.deleteById(book.getId());
    }

    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.findBookByCategory(cid);
        } else {
            return books();
        }
    }



    @GetMapping("/api/book/{id}")
    public Book getById(@PathParam("id") int id){
        return bookService.getById(id);
    }

    @PostMapping("/api/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return bookService.list();
        } else {
            return bookService.search(keywords);
        }
    }

    @GetMapping("/api/category/{id}")
    public Category category(@PathVariable("id") int id)throws Exception{
        return categoryService.getById(id);
    }

    @GetMapping("/api/categories")
    public List<Category> categories() throws Exception {
        return categoryService.list();
    }

    @PostMapping("api/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "d:/Software/webpfojects/garden-note-master/src/main/resources/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8443/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
