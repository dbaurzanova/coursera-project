<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.example.secondjavaee.db.Students" %>


<%
    Gson gsonObj = new Gson();
    Map<Object,Object> map = null;
    List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

    ArrayList<Students> students = (ArrayList<Students>) request.getAttribute("students");
    for (int i=0; i< students.size();i++){
        map = new HashMap<Object,Object>();
        map.put("label", students.get(i).getFull_name());
        map.put("y", students.get(i).getScore());
        list.add(map);
    }


    String dataPoints = gsonObj.toJson(list);
%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Chart</title>
    <%@include file="vendor/head.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
        window.onload = function() {
            var chart = new CanvasJS.Chart("chartContainer", {
                theme: "light2",
                title: {
                    text: "Math test"
                },
                axisX: {
                    title: "Students"
                },
                axisY: {
                    title: "Scores",
                    includeZero: true
                },
                data: [{
                    type: "line",
                    yValueFormatString: "#,##0 points",
                    dataPoints : <%out.print(dataPoints);%>
                }]
            });
            chart.render();

        }
    </script>
</head>
<body>
<%@include file="vendor/navbar.jsp"%>
<div style="padding: 100px">
    <div id="chartContainer" style="height: 370px; width: 100%;"></div>
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</div>

</body>
</html>