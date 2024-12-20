package org.example.service;

import org.example.entity.Book;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BackupThread extends Thread {
    private BookService bookService;
    private String backupFilePath;

    public BackupThread(BookService bookService, String backupFilePath) {
        this.bookService = bookService;
        this.backupFilePath = backupFilePath;
    }

    @Override
    public void run() {
        while (true) {
            try {
                List<Book> books = bookService.searchBooks(""); // 获取所有书籍数据
                FileWriter writer = new FileWriter(backupFilePath);
                for (Book book : books) {
                    writer.write(book.toString() + "\n");
                }
                writer.close();
                System.out.println("Data backed up to " + backupFilePath);
                Thread.sleep(10000); // 每10秒备份一次，可根据需要调整
            } catch (IOException | InterruptedException e) {
                System.out.println("Error during backup: " + e.getMessage());
                break;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}