package com.example.secondjavaee;

import com.example.secondjavaee.db.Admins;
import com.example.secondjavaee.db.DBManager;
import com.example.secondjavaee.db.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //String who = request.getParameter("who");

        String redirect = "/login?emailerror";

        Users user = DBManager.getUser(email);
        if(user!=null){
            redirect = "/login?passworderror";
            if(user.getPassword().equals(password) /*&& user.getType().equals(who)*/){
                request.getSession().setAttribute("CURRENT_USER", user);
                redirect = "/";
            }
        }

        response.sendRedirect(redirect);
        return;
    }
}
