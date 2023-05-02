<%@include file="user.jsp"%>
<nav class="navbar navbar-expand-lg" style="background-color: #592073">
    <div class="container-fluid">
        <a class="navbar-brand" href="/" style="color: white; font-size: 36px">Platonus IITU</a>
        <%
            if(ONLINE){
        %>
        <a class="nav-link" href="/" style="color: white; font-size: 20px; color: black; background-color: #eabbff; border-radius: 3px; margin-left: 5px; padding: 3px">
            <%=currentUser.getFullName()%>
        </a>
        <%
            }
        %>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <%
                    if(ONLINE && currentUser.getWho().equals("admin")){
                %>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/register_student" style="font-size: 20px; color: white">Register a Student</a>
                    </li>
                    <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/register_teacher" style="font-size: 20px; color: white">Register a Teacher</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/logout" style="font-size: 20px; color: white">Logout</a>
                    </li>
                <%
                    } else if(ONLINE && currentUser.getWho().equals("teacher")){
                %>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/stud_info" style="font-size: 20px; color: white">Students Info</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/logout" style="font-size: 20px; color: white">Logout</a>
                    </li>
                <%
                    } else if(ONLINE && currentUser.getWho().equals("student")){
                %>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/stud_profile" style="font-size: 20px; color: white">My Profile</a>
                </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/submission?id=<%=currentUser.getId()%>" style="font-size: 20px; color: white">Submissions</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/logout" style="font-size: 20px; color: white">Logout</a>
                    </li>
                <%
                    }else{
                %>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/login" style="font-size: 20px; color: white">Login</a>
                    </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>