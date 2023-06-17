package com.example.demo;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AddBBook {
@Id
private int rollNo;

private String name;
private String bookName;
private double price_per_week;
//@Column(name = "book_return_due_date")
private LocalDate   book_return_due_date;
private LocalDate  book_borrowed_start_date;
private String email_id;
private int book_ID;
@Column(columnDefinition = "tinyint default 0")
private byte is_returned;
public String getEmail_id() {
	return email_id;
}
public void setEmail_id(String email_id) {
	this.email_id = email_id;
}



public byte isIs_returned() {
	return is_returned;
}
public void setIs_returned(byte is_returned) {
	this.is_returned = is_returned;
}
public String getName() {
	return name;
}
public int getBook_ID() {
	return book_ID;
}
public void setBook_ID(int book_ID) {
	this.book_ID = book_ID;
}
public void setName(String name) {
	this.name = name;
}
public int getRollNo() {
	return rollNo;
}
public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public double getPrice_per_week() {
	return price_per_week;
}
public void setPrice_per_week(double price_per_week) {
	this.price_per_week = price_per_week;
}
public LocalDate   getBook_return_due_date() {
	return book_return_due_date;
}
public void setBook_return_due_date(LocalDate   book_return_due_date) {
	this.book_return_due_date = book_return_due_date;
}
public LocalDate  getBook_borrowed_start_date() {
	return book_borrowed_start_date;
}
public void setBook_borrowed_start_date(LocalDate  book_borrowed_start_date) {
	this.book_borrowed_start_date = book_borrowed_start_date;
}
@Override
public String toString() {
	return "AddBBook [rollNo=" + rollNo + ", Name=" + name + ", bookName=" + bookName + ", price_per_week="
			+ price_per_week + ", book_return_due_date=" + book_return_due_date + ", book_borrowed_start_date="
			+ book_borrowed_start_date + ", email_id=" + email_id + ", book_ID=" + book_ID + ", is_returned="
			+ is_returned + "]";
}

}
