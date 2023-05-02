<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <%@include file="vendor/head.jsp"%>
</head>
<body>
    <%@include file="vendor/navbar.jsp"%>

    <%
        Users user = (Users) request.getAttribute("users");
        if(user!=null){
    %>
        <%
            String success = request.getParameter("success");
            if(success!=null){

        %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                Test saved successfully!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        <%
            }
        %>

        <%
            String error = request.getParameter("error");
            if(error!=null){

        %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                Something went wrong!
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        <%
            }
        %>

    <form action="/test" method="post">
        <input type="hidden" name="id" value="<%=user.getId()%>">
        <input type="hidden" name="email" value="<%=user.getEmail()%>">
        <div style="padding: 40px; font-size: 18px">
            <h2 style="text-align: center; margin-bottom: 20px">Math Test</h2>
            <div style="text-align: match-parent; margin-left: 150px; margin-right: 150px;  padding:40px; background-color: #f3ccff; border-radius: 12px">
                <p style="margin-bottom: 0px; padding-bottom: 5px">
                    Q: What is the square root of (81)?
                </p>
                <input type='radio' name='q1o1' value='9'>
                9
                <br>
                <input type='radio' name='q1o2' value='10'>
                10
                <br>
                <input type='radio' name='q1o3' value='8'>
                8
                <br><br>

                <p style="margin-bottom: 0px; padding-bottom: 5px">
                    Q: What is (15 – 7) = ?
                </p>
                <input type='radio' name='q2o1' value='7'>
                7
                <br>
                <input type='radio' name='q2o2' value='8'>
                8
                <br>
                <input type='radio' name='q2o3' value='9'>
                9
                <br><br>

                <p style="margin-bottom: 0px; padding-bottom: 5px">
                    Q: What is the next prime number after (3)?
                </p>
                <input type='radio' name='q3o1' value='2'>
                2
                <br>
                <input type='radio' name='q3o2' value='15'>
                15
                <br>
                <input type='radio' name='q3o3' value='5'>
                5
                <br><br>

                <p style="margin-bottom: 0px; padding-bottom: 5px">
                    Q: Which is bigger (100) OR Ten squared?
                </p>
                <input type='radio' name='q4o1' value='(100)'>
                (100)
                <br>
                <input type='radio' name='q4o2' value='ten squared'>
                ten squared
                <br>
                <input type='radio' name='q4o3' value='both are the same'>
                both are the same
                <br><br>

                <p style="margin-bottom: 0px; padding-bottom: 5px">
                    Q: What comes after Thousand?
                </p>
                <input type='radio' name='q5o1' value='ten thousand'>
                ten thousand
                <br>
                <input type='radio' name='q5o2' value='million'>
                million
                <br>
                <input type='radio' name='q5o3' value='hundred'>
                hundred
                <br><br>

                <button class="btn btn-danger" style="color: white; border: none">SUBMIT</button>

            </div>
        </div>
    </form>
    <%
        }
    %>
</body>
</html>

