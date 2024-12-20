package org.example.service;

import org.example.entity.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private Connection connect() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/BookManagementSystem?useSSL=false&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "123456";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addBook(Book book) throws ClassNotFoundException {
        String sql = "INSERT INTO books (title, author, publish_date, isbn, description, category) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getPublishDate());
            pstmt.setString(4, book.getIsbn());
            pstmt.setString(5, book.getDescription());
            pstmt.setString(6, book.getCategory());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> searchBooks(String keyword) throws ClassNotFoundException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ? OR isbn LIKE ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublishDate(rs.getString("publish_date"));
                book.setIsbn(rs.getString("isbn"));
                book.setDescription(rs.getString("description"));
                book.setCategory(rs.getString("category"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void deleteBook(int bookId) throws ClassNotFoundException {
        String sql = "DELETE FROM books WHERE book_id = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, bookId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}