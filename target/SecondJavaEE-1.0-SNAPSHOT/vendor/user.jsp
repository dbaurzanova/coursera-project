<%@ page import="com.example.secondjavaee.db.Users" %><%
    Users currentUser = (Users) request.getSession().getAttribute("CURRENT_USER");
    boolean ONLINE = false;
    if(currentUser!=null){
        ONLINE=true;
    }
%>