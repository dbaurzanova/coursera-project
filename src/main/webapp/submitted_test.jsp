<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.secondjavaee.db.Students" %>
<%@ page import="com.example.secondjavaee.db.Test" %>
<%@ page import="com.example.secondjavaee.db.StudentTest" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>

<%@include file="vendor/navbar.jsp"%>
<%
    ArrayList<Students> students = (ArrayList<Students>) request.getAttribute("students");
    StudentTest student_test = (StudentTest) request.getAttribute("student_test");
    Test test = (Test) request.getAttribute("tests");
    Long studId = (Long) request.getAttribute ("studId");
    if(students!=null){
%>
<div class="container" style="text-align:center">
    <div class="row mt-5">
        <div class="col-sm-12">
            <div class="container">
                <div class="row mt-5">
                    <div class="col-sm-12">
                        <div class="jumbotron">
                                    <h1 class="display-4">Math test</h1>
                                    <br>
                                    <p class="lead">You have already passed this test.</p>
<%--                                    <p class="lead">Score: <%=students.get(Integer.parseInt(String.valueOf(studId))-1).getScore()%> / 8</p>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <div style="padding-left: 150px; font-size: 18px; padding-bottom: 100px">
        <p class="lead" style="font-size: 28px;"><b>Your answers are below:</b></p>
        <hr style="margin-right: 150px">
        <p class="lead">Q: What is the square root of (81)?</p>
        <p class="lead">Your answer: <%=student_test.getQuestion1()%> </p>
        <p class="lead"><b>Correct answers: <%=test.getQuestion1()%> </p>
        <br>
        <p class="lead">Q: What is (15 – 7) = ?</p>
        <p class="lead">Your answer: <%=student_test.getQuestion2()%> </p>
        <p class="lead"><b>Correct answers: <%=test.getQuestion2()%> </p>
        <br>
        <p class="lead">Q: What is the next prime number after (3)?</p>
        <p class="lead">Your answer: <%=student_test.getQuestion3()%> </p>
        <p class="lead"><b>Correct answers: <%=test.getQuestion3()%> </p>
        <br>
        <p class="lead">Q: Which is bigger (100) OR Ten squared?</p>
        <p class="lead">Your answer: <%=student_test.getQuestion4()%> </p>
        <p class="lead"><b>Correct answers: <%=test.getQuestion4()%> </p>
        <br>
        <p class="lead">Q: What comes after a thousand?</p>
        <p class="lead">Your answer: <%=student_test.getQuestion5()%> </p>
        <p class="lead"><b>Correct answers: <%=test.getQuestion5()%> </p>
        <br>
        <br>
        <a class="btn btn-primary btn-lg" href="/" role="button"
           style="color: white; border: none; width: 150px; height: 50px;">BACK</a>
    </div>
<%

    }
%>

</body>
</html>


