package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Controller
public class InputController {
    @Autowired
    BookRepo repo;
    
    @Autowired
    private NotificationService notificationService;
    
    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }

    @RequestMapping("/addBook")
    public String addBook(@RequestParam("book_borrowed_start_date") 
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    LocalDate book_borrowed_start_date,@RequestParam("book_return_due_date") 
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    LocalDate book_return_due_date,AddBBook book,Model model) {
        // Check if the book with the same ID already exists in the repository
        Optional<AddBBook> existingBook = repo.findById(book.getRollNo());
        if (existingBook.isPresent()) {
            AddBBook existing = existingBook.get();
            
            // Check if the existing book has not been returned
            if ((existing.isIs_returned())==0) {
                // Book with the same ID exists and has not been returned
                // You can handle this scenario, for example, by showing an error message
                // or redirecting to a different page
            	String errorMessage = "Book with the same ID exists and has not been returned. Only single book issue per student is allowed.";
                model.addAttribute("error", errorMessage);
                return "Error.jsp";
            }
        }
        
        // Book with the same ID does not exist or has been returned
        repo.save(book);
        return "home.jsp";
    }
    
    

    @Scheduled(cron = "0 0 0 * * *") // Run every day at mid night
    public void checkOverdueBooks() {
        List<AddBBook> overdueBooks = repo.findOverdueBooks();
        LocalDate currentDate = LocalDate.now();
        
        for (AddBBook book : overdueBooks) {
            LocalDate returnDueDate = book.getBook_return_due_date();
                    
            
            long daysOverdue = ChronoUnit.DAYS.between(returnDueDate, currentDate);
            String name= book.getName();
            String bookName=book.getBookName();
            int bookID=book.getBook_ID();
            notificationService.sendNotification(book.getRollNo(), daysOverdue, name,bookName,bookID);
        }
    }



    @RequestMapping("/retrieveData")
    public String retrieveData(@RequestParam int rollNo, Model model) {
        try {
            AddBBook book = repo.findById(rollNo).orElseThrow(NoSuchElementException::new);
            
            // Calculate the number of days between the borrowed start date and the current system date
            LocalDate currentDate = LocalDate.now();
            LocalDate borrowedStartDate = book.getBook_borrowed_start_date();
            double daysBetween = ChronoUnit.DAYS.between(borrowedStartDate, currentDate);
            
            // Calculate the number of weeks and the initial count
            double pricePerWeek = book.getPrice_per_week();
            double count = (daysBetween / 7) * pricePerWeek;
            
            // Check if the current system date extends the return due date
            LocalDate returnDueDate = book.getBook_return_due_date();
            if (currentDate.isAfter(returnDueDate)) {
                // Calculate the number of days the return is delayed
                long daysDelayed = ChronoUnit.DAYS.between(returnDueDate, currentDate);
                
                // Add the fine for each delayed day to the count
                double finePerDay = 50;
                count += (finePerDay * daysDelayed);
            }
            
            // Add the count to the model attributes
            model.addAttribute("count", count);
            model.addAttribute("rollNumber", book.getRollNo());
            model.addAttribute("name", book.getName());
            model.addAttribute("bookId", book.getBook_ID());
            model.addAttribute("bookName", book.getBookName());
            model.addAttribute("pricePerWeek", book.getPrice_per_week());
            model.addAttribute("borrowedStartDate", book.getBook_borrowed_start_date());
            model.addAttribute("returnDueDate", book.getBook_return_due_date());

            return "ShowInfo.jsp";
        } catch (NoSuchElementException e) {
            model.addAttribute("error", "Record not found for roll number: " + rollNo);
            return "Error.jsp";
        }
    }
    @RequestMapping("/setFlag") 
    public String setFlag(@RequestParam int rollNo, @RequestParam String isReturned, Model model) {
        try {
            AddBBook book = repo.findById(rollNo).orElseThrow(NoSuchElementException::new);
            
            if (isReturned.equals("yes")) {
                book.setIs_returned((byte)1); // Set the is_returned flag to true
            }

            // Save the updated book record
            repo.save(book);

            model.addAttribute("success", "Flag updated successfully for roll number: " + rollNo);
        } catch (NoSuchElementException e) {
            model.addAttribute("error", "Record not found for roll number: " + rollNo);
        }

        return "home.jsp";
    }


    
}
