<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body style="background-color: #eabbff">
<%@include file="vendor/navbar.jsp"%>

<div class="container">
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">
            <h4 class="mb-5">
                Login to the System
            </h4>

            <%
               String passError = request.getParameter("passworderror");
               if(passError != null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Incorrect password!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
               }
            %>
            <%
               String emailError = request.getParameter("emailerror");
               if(emailError != null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Incorrect email!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <form action="/auth" method="post">
                <div class="form-group">
                   <label>EMAIL:</label>
                   <input type="email" required class="form-control" name="email">
                </div>
                <div class="form-group">
                   <label>PASSWORD:</label>
                   <input type="password" required class="form-control" name="password">
                </div>
                <div class="form-group mt-4">
                   <button type="submit" class="btn btn-success" onclick="action">LOGIN</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
