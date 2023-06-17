package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    
    BookRepo repo;
    public void sendNotification(int rollNo, long daysOverdue,String name,String bookName,int bookID) {
        // Implement your notification logic here
        // You can send an email, SMS, or use a messaging service to notify the student
        // Example: Send an email notification
        String email = getEmailForRollNo(rollNo);
        String subject = "Book Return Overdue";
        String message = "Dear " + name + ",\n\n"
        	    + "I hope this email finds you well. I am writing to inform you about the overdue status of a book associated with your account. It has come to our attention that the book, titled " + bookName + ", has not been returned within the designated timeframe.\n\n"
        	    + "According to our records, the book has exceeded its due date by " + daysOverdue + " days. We kindly request that you return the book as soon as possible to avoid any inconvenience or additional charges.\n\n"
        	    + "To assist us in efficiently processing the return, please ensure that you return the book with the following details:\n\n"
        	    + "Roll Number: " + rollNo + "\n"
        	    + "Book Name: " + bookName + "\n\n"
        	    + "Book Name: " + bookID + "\n\n"
        	    + "Your prompt action in returning the book would be greatly appreciated. Should you have any questions or require further assistance, please do not hesitate to contact us. We are here to assist you.\n\n"
        	    + "Thank you for your attention to this matter, and we look forward to receiving the book at the earliest.\n\n"
        	    + "Best regards,\n"
        	    + "SYSTEM GENERATED MAIL\n"
        	    + "LIBRARY ADMIN\n"
        	    + "KNOWLEDGE POINT";
        EmailUtil.sendEmail(email, subject, message);
    }

    private String getEmailForRollNo(int rollNo) {
        // Implement logic to retrieve the student's email based on the roll number
        // Example: Query the database to fetch the student's email address
        // return repository.getEmailByRollNo(rollNo);
    	
        return repo.getEmailByRollNo(rollNo); 
    }
}

