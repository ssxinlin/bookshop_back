package com.example.store.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Book implements Serializable {

    private Integer bookId;

    private String bookNumber;

    private String bookName;

    private String author;

    private String translator;

    private Integer price;

    private String bookType;

    private String evaluate;

    private String bookImg;

    private Integer isPutaway;

    private Date putawayTime;

    private String modifiedUser;

    private Date modifiedTime;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public Integer getIsPutaway() {
        return isPutaway;
    }

    public void setIsPutaway(Integer isPutaway) {
        this.isPutaway = isPutaway;
    }

    public Date getPutawayTime() {
        return putawayTime;
    }

    public void setPutawayTime(Date putawayTime) {
        this.putawayTime = putawayTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) && Objects.equals(bookNumber, book.bookNumber) && Objects.equals(bookName, book.bookName) && Objects.equals(author, book.author) && Objects.equals(translator, book.translator) && Objects.equals(price, book.price) && Objects.equals(bookType, book.bookType) && Objects.equals(evaluate, book.evaluate) && Objects.equals(bookImg, book.bookImg) && Objects.equals(isPutaway, book.isPutaway) && Objects.equals(putawayTime, book.putawayTime) && Objects.equals(modifiedUser, book.modifiedUser) && Objects.equals(modifiedTime, book.modifiedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookNumber, bookName, author, translator, price, bookType, evaluate, bookImg, isPutaway, putawayTime, modifiedUser, modifiedTime);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookNumber='" + bookNumber + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", translator='" + translator + '\'' +
                ", price=" + price +
                ", bookType='" + bookType + '\'' +
                ", evaluate='" + evaluate + '\'' +
                ", bookImg='" + bookImg + '\'' +
                ", isPutaway=" + isPutaway +
                ", putawayTime=" + putawayTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
