package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepo extends CrudRepository<AddBBook,Integer> {
	

	@Query("SELECT b FROM AddBBook b WHERE b.book_return_due_date< CURRENT_DATE AND b.is_returned = 0 ")
	List<AddBBook> findOverdueBooks();

	@Query("SELECT b.email_id FROM AddBBook b WHERE b.rollNo = :rollNo")
	String getEmailByRollNo(@Param("rollNo") int rollNo);
}
