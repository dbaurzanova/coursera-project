package com.example.secondjavaee;

import com.example.secondjavaee.db.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id =0L;
        try{
            id = Long.parseLong(request.getParameter("id"));

        }catch (Exception e){

        }

        Users user = DBManager.getUserById(id);
        if(user!=null){
            Users userByEmail = DBManager.getUser(user.getEmail());
            request.setAttribute("users", userByEmail);
            request.getRequestDispatcher("/test.jsp").forward(request, response);

        }else{
            request.getRequestDispatcher("/").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String email = request.getParameter("email");

        String q1o1 = request.getParameter("q1o1");
        String q1o2 = request.getParameter("q1o2");
        String q1o3 = request.getParameter("q1o3");
        String question1 = "";

        Test test = DBManager.getTest(1L);
        int points = 0;
        if(q1o1!=null){
            question1 = q1o1;
            if(test.getQuestion1().equals(q1o1)){
                points++;
            }
        }else if(q1o2!=null){
            question1 = q1o2;
            if(test.getQuestion1().equals(q1o2)){
                points++;
            }
        }else if(q1o3!=null){
            question1 = q1o3;
            if(test.getQuestion1().equals(q1o3)){
                points++;
            }
        }

        String q2o1 = request.getParameter("q2o1");
        String q2o2 = request.getParameter("q2o2");
        String q2o3 = request.getParameter("q2o3");
        String question2 = "";

        if(q2o1!=null){
            question2 = q2o1;
            if(test.getQuestion2().equals(q2o1)){
                points++;
            }
        }else if(q2o2!=null){
            question2 = q2o2;
            if(test.getQuestion2().equals(q2o2)){
                points++;
            }
        }else if(q2o3!=null){
            question2 = q2o3;
            if(test.getQuestion2().equals(q2o3)){
                points++;
            }
        }

        String q3o1 = request.getParameter("q3o1");
        String q3o2 = request.getParameter("q3o2");
        String q3o3 = request.getParameter("q3o3");
        String question3 = "";

        if(q3o1!=null){
            question3 = q3o1;
            if(test.getQuestion3().equals(q3o1)){
                points++;
            }
        }else if(q3o2!=null){
            question3 = q3o2;
            if(test.getQuestion3().equals(q3o2)){
                points++;
            }
        }else if(q3o3!=null){
            question3 = q3o3;
            if(test.getQuestion3().equals(q3o3)){
                points++;
            }
        }

        String q4o1 = request.getParameter("q4o1");
        String q4o2 = request.getParameter("q4o2");
        String q4o3 = request.getParameter("q4o3");
        String question4 = "";

        if(q4o1!=null){
            question4 = q4o1;
            if(test.getQuestion4().equals(q4o1)){
                points++;
            }
        }else if(q4o2!=null){
            question4 = q4o2;
            if(test.getQuestion4().equals(q4o2)){
                points++;
            }
        }else if(q4o3!=null){
            question4 = q4o3;
            if(test.getQuestion4().equals(q4o3)){
                points++;
            }
        }

        String q5o1 = request.getParameter("q5o1");
        String q5o2 = request.getParameter("q5o2");
        String q5o3 = request.getParameter("q5o3");
        String question5 = "";

        if(q5o1!=null){
            question5 = q5o1;
            if(test.getQuestion5().equals(q5o1)){
                points++;
            }
        }else if(q5o2!=null){
            question5 = q5o2;
            if(test.getQuestion5().equals(q5o2)){
                points++;
            }
        }else if(q5o3!=null){
            question5 = q5o3;
            if(test.getQuestion5().equals(q5o3)){
                points++;
            }
        }


        System.out.println(email);
        String redirect = "/test?error";

        Students student = DBManager.getStudent(email);

        int score = points * 100 / 5;

        student.setEmail(student.getEmail());
        student.setPassword(student.getPassword());
        student.setFull_name(student.getFull_name());
        student.setGroup(student.getGroup());
        student.setGpa(student.getGpa());
        student.setTest_is_done(1);
        student.setScore(score);


        StudentTest student_test = new StudentTest(null, email, question1, question2, question3, question4, question5);
        System.out.println(student_test.getEmail());
        System.out.println(student_test.getQuestion1());
        if(DBManager.addStudentTests(student_test) && DBManager.updateStudentSubmissionStatus(student)){
            redirect = "/test?success";
        }

        response.sendRedirect(redirect);
    }
}
