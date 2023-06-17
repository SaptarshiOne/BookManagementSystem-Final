package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class NotificationScheduler {

    @Autowired
    private BookRepo repo;

    @Autowired
    private NotificationService notificationService;

    @Scheduled(cron = "0 0 0 * * *") // Run every day at midnight
    public void checkOverdueBooks() {
        List<AddBBook> overdueBooks = repo.findOverdueBooks();
        for (AddBBook book : overdueBooks) {
            LocalDate currentDate = LocalDate.now();
            LocalDate returnDueDate = book.getBook_return_due_date();
            String name= book.getName();
            String bookName=book.getBookName();
            int bookID=book.getBook_ID();

            LocalDate dueDate = returnDueDate;
            long daysOverdue = ChronoUnit.DAYS.between(dueDate, currentDate);
            notificationService.sendNotification(book.getRollNo(), daysOverdue,name,bookName,bookID);
        }
    }
}


