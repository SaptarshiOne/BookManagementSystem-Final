<!DOCTYPE html>
<html>
<head>
  <title>Book Borrowing Form</title>
  
  <style>
    /* CSS for form styling */
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }

    .container {
      width: 400px;
      margin: 0 auto;
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }

    .form-group {
      margin-bottom: 15px;
    }

    .form-group label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }

    .form-group input[type="text"],
    .form-group input[type="date"],
    .form-group select {
      width: 100%;
      padding: 8px;
      border-radius: 5px;
      border: 1px solid #ccc;
    }

    .form-group input[type="submit"],
    .form-group input[type="reset"] {
      background-color: #4caf50;
      color: #fff;
      border: none;
      padding: 10px 20px;
      cursor: pointer;
      border-radius: 5px;
    }

    .form-group input[type="submit"]:hover,
    .form-group input[type="reset"]:hover {
      background-color: #45a049;
    }
    
    /* Additional styling for the border */
    .border {
      border: 1px solid #ccc;
      padding: 20px;
      margin-top: 20px;
      border-radius: 5px;
    }
  </style>
</head>
<body>
  <div class="container">
    <h2>Book Borrowing Form</h2>
    
  
    <form action="addBook" method="post">
      <div class="form-group">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>
      </div>
      
      <div class="form-group">
        <label for="book_ID">BookID:</label>
        <input type="text" id="book_ID" name="book_ID" required>
      </div>
      
      <div class="form-group">
        <label for="rollNo">Roll Number:</label>
        <input type="text" id="rollNo" name="rollNo" required>
      </div>
      
      <div class="form-group">
        <label for="bookName">Name of the Book:</label>
        <input type="text" id="bookName" name="bookName" required>
      </div>
      
      <div class="form-group">
        <label for="email_id">Email:</label>
        <input type="text" id="email_id" name="email_id" required>
      </div>
      
      <div class="form-group">
        <label for="price_per_week">Rate of the Book (Price per week in Rs):</label>
        <input type="text" id="price_per_week" name="price_per_week" required>
      </div>
      <div class="form-group">
        <label for="book_borrowed_start_date">Book Borrow Date:</label>
        <input type="date" id="book_borrowed_start_date" name="book_borrowed_start_date" required>
      </div>
      <div class="form-group">
        <label for="book_return_due_date">Book Return Due Date:</label>
        <input type="date" id="book_return_due_date" name="book_return_due_date" required>
      </div>
      <div class="form-group">
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
      </div>
    </form>
    
    <!-- Additional form for retrieving student and book data -->
    <div class="border">
      <h2>Retrieve Student and Book Data</h2>
      <form action="retrieveData" method="post">
        <div class="form-group">
          <label for="rollNo">Roll Number:</label>
          <input type="text" id="rollNo" name="rollNo" required>
        </div>
           <div class="form-group">
            <label for="currentDate">Current System Date:</label>
            <input type="text" id="currentDate" name="currentDate" value="<%= new java.util.Date() %>" readonly>
        </div>

        <div class="form-group">
          <input type="submit" value="Submit">
        </div>
      </form>
      
    </div>
  </div>
</body>
</html>
