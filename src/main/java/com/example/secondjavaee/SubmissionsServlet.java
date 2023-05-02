package com.example.secondjavaee;

import com.example.secondjavaee.db.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SubmissionsServlet", value = "/submission")
public class SubmissionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id =0L;
        try{
            id = Long.parseLong(request.getParameter("id"));

        }catch (Exception e){

        }

        Users user = DBManager.getUserById(id);

        ArrayList<Students> students = DBManager.getStudents();
        Long studId = -1L;
        for(int i=0; i< students.size(); i++){
            if(students.get(i).getEmail().equals(user.getEmail())){
                i=i+1;
                studId = new Long(i);
            }
        }

        Students student = DBManager.getStudent(user.getEmail());
        Test test = DBManager.getTest(1L);
        StudentTest studentTest = DBManager.getStudentTestsByEmail(student.getEmail());
        if(studentTest!=null){
            int test_is_done = 1;
            student.setTest_is_done(test_is_done);
            DBManager.updateStudentSubmissionStatus(student);
        }
        if(student.getTest_is_done() == 1){
            request.setAttribute("students", students);
            request.setAttribute("student_test", studentTest);
            request.setAttribute("tests", test);
            request.setAttribute("studId", studId);
            request.getRequestDispatcher("/submitted_test").include(request, response);
        }else{
             request.setAttribute("users", user);
             request.getRequestDispatcher("/submission.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
