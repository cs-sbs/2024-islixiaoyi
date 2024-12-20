package org.example;

import org.example.entity.Book;
import org.example.entity.User;
import org.example.service.BookService;
import org.example.service.UserService;
import org.example.service.BackupThread;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        BookService bookService = new BookService();
        BackupThread backupThread = new BackupThread(bookService, "backup.txt");
        User currentUser = null;
        boolean running = true;

        // 启动数据备份线程
        backupThread.start();

        while (running) {
            System.out.println("Welcome to the Book Management System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Books");
            System.out.println("4. Search Books");
            System.out.println("5. Add a Book (Admin Only)");
            System.out.println("6. Delete a Book (Admin Only)");
            System.out.println("7. Logout");
            System.out.println("8. Exit");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 清除换行符

            switch (choice) {
                case 1:
                    registerUser(scanner, userService);
                    break;
                case 2:
                    currentUser = loginUser(scanner, userService);
                    if (currentUser != null) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Login failed. Incorrect username or password.");
                    }
                    break;
                case 3:
                    viewBooks(bookService);
                    break;
                case 4:
                    searchBooks(scanner, bookService);
                    break;
                case 5:
                    if (currentUser != null && "admin".equals(currentUser.getRole())) {
                        addBook(scanner, bookService);
                    } else {
                        System.out.println("Access denied. Only admins can add books.");
                    }
                    break;
                case 6:
                    if (currentUser != null && "admin".equals(currentUser.getRole())) {
                        deleteBook(scanner, bookService);
                    } else {
                        System.out.println("Access denied. Only admins can delete books.");
                    }
                    break;
                case 7:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void registerUser(Scanner scanner, UserService userService) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (user/admin): ");
        String role = scanner.nextLine();
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);
        if (userService.registerUser(newUser)) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed. Username may already exist.");
        }
    }

    private static User loginUser(Scanner scanner, UserService userService) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return userService.loginUser(username, password);
    }

    private static void viewBooks(BookService bookService) throws ClassNotFoundException {
        List<Book> books = bookService.searchBooks("");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void searchBooks(Scanner scanner, BookService bookService) throws ClassNotFoundException {
        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();
        List<Book> books = bookService.searchBooks(keyword);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void addBook(Scanner scanner, BookService bookService)throws ClassNotFoundException  {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publish date: ");
        String publishDate = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setPublishDate(publishDate);
        newBook.setIsbn(isbn);
        newBook.setDescription(description);
        newBook.setCategory(category);
        bookService.addBook(newBook);
        System.out.println("Book added successfully!");
    }

    private static void deleteBook(Scanner scanner, BookService bookService) throws ClassNotFoundException {
        System.out.print("Enter book ID to delete: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // 清除换行符
        bookService.deleteBook(bookId);
        System.out.println("Book deleted successfully!");
    }
}