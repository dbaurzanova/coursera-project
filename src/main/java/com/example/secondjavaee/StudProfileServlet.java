package com.example.secondjavaee;

import com.example.secondjavaee.db.DBManager;
import com.example.secondjavaee.db.Test;
import com.example.secondjavaee.db.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudProfileServlet", value = "/stud_profile")
public class StudProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Test> tests = DBManager.getTests();
        request.setAttribute("tests", tests);
        Users currentUser = (Users)request.getSession().getAttribute("CURRENT_USER");
        if(currentUser!=null){
            request.getRequestDispatcher("/stud_profile.jsp").forward(request, response);

        }else{
            response.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
