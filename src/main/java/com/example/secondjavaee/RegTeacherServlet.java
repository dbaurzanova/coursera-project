package com.example.secondjavaee;

import com.example.secondjavaee.db.DBManager;
import com.example.secondjavaee.db.Students;
import com.example.secondjavaee.db.Teachers;
import com.example.secondjavaee.db.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/register_teacher")
public class RegTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/register_teacher.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String full_name = request.getParameter("full_name");

        String redirect = "/register_teacher?passerror";
        if(password.equals(password2)){
            redirect = "/register_teacher?emailerror";

            Teachers teacher = DBManager.getTeacher(email);

            if(teacher == null){

                Teachers teacher_new = new Teachers(null, email, password, full_name);
                Users user = new Users(null, email, password, full_name, "teacher");

                if(DBManager.addTeacher(teacher_new) && DBManager.addUser(user)) {
                    redirect = "/register_teacher?success";
                }
            }
        }

        response.sendRedirect(redirect);

    }
}
