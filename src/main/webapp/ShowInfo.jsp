<!DOCTYPE html>
<html>
<head>
    <title>Borrowing Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        h1 {
            color: #333333;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        .form-message {
            margin-bottom: 10px;
            color: #666666;
        }

        .submit-btn {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        .submit-btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Borrowing Details</h1>

    <table>
        <tr>
            <th>Student Roll Number:</th>
            <td><%= request.getAttribute("rollNumber") %></td>
        </tr>
        <tr>
            <th>Name:</th>
            <td><%= request.getAttribute("name") %></td>
        </tr>
        <tr>
            <th>Book ID:</th>
            <td><%= request.getAttribute("bookId") %></td>
        </tr>
        <tr>
            <th>Book Name:</th>
            <td><%= request.getAttribute("bookName") %></td>
        </tr>
        <tr>
            <th>Price per Week:</th>
            <td><%= request.getAttribute("pricePerWeek") %></td>
        </tr>
        <tr>
            <th>Book Borrow Date:</th>
            <td><%= request.getAttribute("borrowedStartDate") %></td>
        </tr>
        <tr>
            <th>Book Return Due Date:</th>
            <td><%= request.getAttribute("returnDueDate") %></td>                  
        </tr>
         <tr>
            <th>Total Price To Be Paid:</th>
            <td><%= request.getAttribute("count") %></td>
        </tr>
    </table>
      
    <div class="form-message">
        If the amount is paid and the book is returned, click the Submit button.
    </div>

    <form action="setFlag" method="post" onsubmit="document.getElementById('isReturned').value='yes';">
        <!-- Add a hidden input field to hold the rollNo value and is_returned flag -->
        <input type="hidden" name="rollNo" value="<%= request.getAttribute("rollNumber") %>">
        <input type="hidden" id="isReturned" name="isReturned" value="no">
        
        <div class="form-group">
            <input type="submit" class="submit-btn" value="Submit">
        </div>
    </form>
</body>
</html>
