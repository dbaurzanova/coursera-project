<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body style="background-color: #eabbff">
<%@include file="vendor/navbar.jsp"%>
<div class="container">
    <div class="row mt-5">
        <div class="col-sm-6 offset-3">

            <%
                String passerror = request.getParameter("passerror");
                if(passerror!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Passwords are not the same!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>

            <%
                }
            %>
            <%
                String emailerror = request.getParameter("emailerror");
                if(emailerror!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                This students is already exists!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>

            <%
                }
            %>
            <%
                String success = request.getParameter("success");
                if(success!=null){
            %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Student added successfully!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>

            <%
                }
            %>

            <form action="/register_teacher" method="post">
                <div class="container" style="padding-left: 50px; padding-bottom: 20px; background-color: #E9EFF2">
                    <h3 style="padding-top: 35px;">REGISTER TO THE SYSTEM</h3>

                    <div class="form-group" style="padding: 5px; width: 400px">
                        <label style="padding-bottom: 10px;">Email: </label>
                        <input type="text" name="email" class="form-control" placeholder="Email" style="padding-bottom: 10px">
                    </div>

                    <div class="form-group" style="padding: 5px; width: 400px">
                        <label style="padding-bottom: 10px;">Password: </label>
                        <input type="password" name="password" class="form-control" placeholder="Password">
                    </div>

                    <div class="form-group" style="padding: 5px; width: 400px">
                        <label style="padding-bottom: 10px;">Retype Password: </label>
                        <input type="password" name="password2" class="form-control" placeholder="Password">
                    </div>

                    <div class="form-group" style="padding: 5px; width: 400px">
                        <label style="padding-bottom: 10px;">Full name: </label>
                        <input type="text" name="full_name" class="form-control" placeholder="Full name" style="padding-bottom: 10px">
                    </div>

                    <div class="form-group" style="padding-left: 7px; padding-top: 35px">
                        <button class="btn btn-success" style="background-color:#00008c; border: none; -webkit-text-fill-color: white">ADD USER</button>
                    </div>

                </div>
            </form>
        </div>

    </div>
</div>
</body>
</html>
