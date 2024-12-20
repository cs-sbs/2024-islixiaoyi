package org.example.entity;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String publishDate;
    private String isbn;
    private String description;
    private String category;

    // 构造函数
    public Book() {
    }

    public Book(int bookId, String title, String author, String publishDate, String isbn, String description, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.isbn = isbn;
        this.description = description;
        this.category = category;
    }

    // Getter 和 Setter 方法
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // toString 方法
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", isbn='" + isbn + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}