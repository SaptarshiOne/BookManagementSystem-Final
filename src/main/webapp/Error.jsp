<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
  
    <style>
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
    
        h2 {
            text-align: center;
            color: #e74c3c;
            margin-top: 0;
        }
    
        .error-message {
            color: #e74c3c;
            text-align: center;
            font-size: 18px;
            margin-top: 20px;
        }
    
        .error-details {
            margin-top: 30px;
            border-top: 1px solid #ccc;
            padding-top: 20px;
            font-size: 14px;
        }
    
        .error-details p {
            margin-bottom: 10px;
        }
    
        .error-details label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Error</h2>
        <p class="error-message">${error}</p>
        
        <div class="error-details">
            <p>
                <label>Error Details:</label><br>
               There has been a system exception. Contact the administrator
            </p>
            <p>
                <label>Suggested Actions:</label><br>
                Retry again by returning to the home page.
            </p>
        </div>
    </div>
</body>
</html>
