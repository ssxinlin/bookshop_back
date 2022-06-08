package com.example.store.mapper;

import com.example.store.pojo.Book;

public interface BookMapper {

    Book getBookInfo(String bookName);

    Integer addBook(Book book);

}
