<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.revature.config.DatabaseConnection"%>
<!DOCTYPE html>
<html>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

<head>
<meta charset="ISO-8859-1">
<html lang="en">
  <title>report summary</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%
Connection connection = DatabaseConnection.getConnection();
%>


 <!-- header start -->
 
 <nav class="navbar navbar-expand-lg bg-primary navbar-primary " data-bs-theme="primary">
        <div class="container-fluid ">
            <a class="navbar-brand fw-bolder fs-1" href="main.html"><img src="img/logo_kb.png" alt="" width="80px"
                    style="border-radius: 50%;"></a>
            
            
        </div>
    </nav>
 

 <!-- end header -->



 <section class="h-100 gradient-form" style="background-color: #eee">
  <div class="container py-5 h-100">
   <div
    class="row d-flex justify-content-center align-items-center h-100">
    <div class="col-xl-10">
     <div class="card rounded-3 text-black">
      <div class="row g-0">
       <div class="col-lg-10">
        <div class="card-body p-md-5 mx-md-4">
         <div class="text-center ">
        

          <h1 style="color: RED">Product Details :</h1>
          <table class="table table-border table table-striped">
           <tr>
            <td>Product ID</td>
            <td>Total-Quantity</td>
          
     


           </tr>
           <%
           try {

        	              
            Statement statement = connection.createStatement();         
            ResultSet resultSet = statement.executeQuery("select PRODUCT_ID, sum(QUANTITY) as total from order_details group by PRODUCT_ID , quarter(ORDER_DATE);");

            while (resultSet.next()) {
            	 
           %>
           <tr>
            <td><%=resultSet.getInt(1)%></td>
            <td><%=resultSet.getString(2)%></td>
           </tr>
           <%
           
           }
           //connection.close();
           } catch (Exception e) {
           e.printStackTrace();
           }
           %>

          </table>

          
           <br>
           <form method="" action="index.html" id="firstForm">
          
           <div style="Text-align: center">
            <a href="index.html"
             class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3">Home</a>
           </div>
          </form>


         </div>
        </div>
       </div>
      </div>
     </div>
    </div>
   </div>
  </div>
 </section>


</body>
</html>


