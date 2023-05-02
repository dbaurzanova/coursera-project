<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>

<div class="container" style="text-align:center">
    <div class="row mt-5">
        <div class="col-sm-12">
            <div class="container">
                <div class="row mt-5">
                    <div class="col-sm-12">
                        <div class="jumbotron">
                            <h1 class="display-4">Math Test </h1>
                            <br><br>
                            <p class="lead">Here are 5 questions for 30 minutes.</p>
                            <p class="lead">Deadline is due to May 25, 2023, 00:00 pm.</p>
                            <br><br><br>
                            <a class="btn btn-primary btn-lg" href="/test?id=<%=currentUser.getId()%>" role="button"
                               style="color: white; background-color: darkred; border: none; width: 150px; height: 50px;">Let's start!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
