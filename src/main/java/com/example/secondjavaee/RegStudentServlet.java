package com.example.secondjavaee;

import com.example.secondjavaee.db.DBManager;
import com.example.secondjavaee.db.Students;
import com.example.secondjavaee.db.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegStudentServlet", value = "/register_student")
public class RegStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/register_student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String full_name = request.getParameter("full_name");
        String gpa = request.getParameter("gpa");
        String group = request.getParameter("group");
        int score = 0;
        int test_is_done = 0;

        String redirect = "/register_student?passerror";
        if(password.equals(password2)){
            redirect = "/register_student?emailerror";

            Students student = DBManager.getStudent(email);

            if(student == null){

                Students student_new = new Students(null, email, password, full_name, group, gpa, test_is_done, score);
                Users user = new Users(null, email, password, full_name, "student");

                if(DBManager.addStudent(student_new) && DBManager.addUser(user)) {
                    redirect = "/register_student?success";
                }
            }
        }

        response.sendRedirect(redirect);

    }
}
