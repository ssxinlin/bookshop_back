package com.example.store.mapper;

import com.example.store.pojo.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookMapperTests {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void addBook() {
        Book book = new Book();
        book.setBookNumber("1");
        book.setBookName("Vue.js设计与实现");
        book.setAuthor("霍春阳");
        book.setPrice(85);
        book.setBookType("编程语言与程序设计");
        Integer rows = bookMapper.addBook(book);
        System.out.println(rows);
    }

    @Test
    public void getBookInfo() {
        Book book = bookMapper.getBookInfo("Vue.js设计与实现");
        System.out.println("book： " + book);
    }

}
