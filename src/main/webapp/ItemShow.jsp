<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.revature.config.DatabaseConnection"%>


<!DOCTYPE html>
<html>
<title>Search Item</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

<style>
body {
 background-color: #e4e7ff;
}
</style>
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
            <td>Product Name</td>
            <td>Product Count</td>
            <td>Total Stock</td>
            <td>Best Before</td>
            <td>Price Per Unit</td>
            <td>Type-of-Product</td>
     


           </tr>
           <%
           try {
        	   //String id = request.getParameter("ID"); 
        	   int id=101;
        
            
            PreparedStatement statement = connection.prepareStatement("select * from product where PRODUCT_ID=?;");
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
            	 
           %>
           <tr>
            <td><%=resultSet.getInt(1)%></td>
            <td><%=resultSet.getString(2)%></td>
            <td><%=resultSet.getInt(3)%></td>
            <td><%=resultSet.getInt(4)%></td>
            <td><%=resultSet.getString(5)%></td>
            <td><%=resultSet.getDouble(6)%></td>
            <td><%=resultSet.getString(7)%></td>
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
