package com.example.secondjavaee;

import com.example.secondjavaee.db.DBManager;
import com.example.secondjavaee.db.Students;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudInfoServlet", value = "/stud_info")
public class StudInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Students> students = DBManager.getStudents();
        request.setAttribute("students", students);

        request.getRequestDispatcher("/chart.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
