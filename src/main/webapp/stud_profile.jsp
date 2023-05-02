<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Profile</title>
    <%@include file="vendor/head.jsp"%>
</head>
<%@include file="vendor/navbar.jsp"%>

<body>
<div style="margin: 0; padding-top: 15px; padding-left: 50px; padding-right: 50px; font-family: Arial">
    <div class="main" style="display: flex; flex-direction: row; margin: 20px;
    justify-content: space-between;">
        <div class="left-main" style="width: 22%;">
            <div class="left-main-photo">
                <img src="https://d2v9ipibika81v.cloudfront.net/uploads/sites/210/Profile-Icon.png"
                     style="width: 100%; padding-bottom: 25px">
            </div>

            <div style="border: solid #d5d5d5 1px; border-radius: 5px">
                <div class="left-main-sections">
                    <div class="section-text" style="border-bottom: solid #d5d5d5 1px; padding: 10px; color: #0480ff">
                        <b style="padding-left: 25px"><a href="/"><%=currentUser.getFullName()%></a></b></div>
                    <div class="section-text" style="border-bottom: solid #d5d5d5 1px; padding: 10px; color: #0480ff">
                        <b style="padding-left: 25px; color: darkred">Settings</b></div>
                </div>
            </div>
     </div>


</div>
</div>


</body>
</html>
