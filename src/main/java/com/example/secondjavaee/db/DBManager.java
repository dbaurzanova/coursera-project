package com.example.secondjavaee.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;

    static {

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/second_javaee_db?useUnicode=true&serverTimezone=UTC",
                    "root",
                    "");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static boolean addStudent(Students student){
        int rows = 0;

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "INSERT INTO students (id, email, password, full_name, group, gpa, test_is_done, score) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, student.getEmail());
            preparedStatement.setString(2, student.getPassword());
            preparedStatement.setString(3, student.getFull_name());
            preparedStatement.setString(4, student.getGroup());
            preparedStatement.setString(5, student.getGpa());
            preparedStatement.setInt(6, student.getTest_is_done());
            preparedStatement.setInt(7, student.getScore());

            rows = preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return rows>0;
    }

    public static boolean addTeacher(Teachers teacher){
        int rows2 = 0;

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "INSERT INTO teachers (id, email, password, full_name) " +
                    "VALUES (NULL, ?, ?, ?)");

            preparedStatement.setString(1, teacher.getEmail());
            preparedStatement.setString(2, teacher.getPassword());
            preparedStatement.setString(3, teacher.getFull_name());

            rows2 = preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return rows2>0;
    }

    public static boolean addUser(Users user){
        int rows3 = 0;

        try{

            PreparedStatement preparedStatement = connection.prepareStatement("" +
                    "INSERT INTO users (id, email, password, full_name, who)" +
                    "VALUES (NULL, ?, ?, ?, ?)");

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            preparedStatement.setString(4, user.getWho());

            rows3 = preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return rows3>0;
    }

    public static Users getUser(String email){

        Users user = null;
        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                user = new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getString("who")
                );
            }

            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static ArrayList<Users> getUsers(){
        ArrayList<Users> users = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                users.add(new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("fullName"),
                        resultSet.getString("who")
                ));

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static Users getUserById(Long id){
        Users user = null;

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                user = new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getString("who")
                );

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }



    public static Admins getAdmin(String email){

        Admins admin = null;
        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM admins WHERE email = ?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                admin = new Admins(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name")
                );
            }

            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }
        return admin;
    }

    public static Students getStudent(String email){

        Students student = null;
        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE email = ?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                student = new Students(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getString("group"),
                        resultSet.getString("gpa"),
                        resultSet.getInt("test_is_done"),
                        resultSet.getInt("score")
                );
            }

            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    public static Students getStudentById(Long id){
        Students student = null;

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE id = ?");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                student = new Students(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("fullName"),
                        resultSet.getString("group"),
                        resultSet.getString("gpa"),
                        resultSet.getInt("test_is_done"),
                        resultSet.getInt("score")
                );

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    public static ArrayList<Students> getStudents(){
        ArrayList<Students> students = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                students.add(new Students(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name"),
                        resultSet.getString("group"),
                        resultSet.getString("gpa"),
                        resultSet.getInt("test_is_done"),
                        resultSet.getInt("score")
                ));

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    public static Teachers getTeacher(String email){

        Teachers teacher = null;
        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM admins WHERE email = ?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){
                teacher = new Teachers(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name")
                );
            }

            statement.close();


        }catch (Exception e){
            e.printStackTrace();
        }
        return teacher;
    }


    public static Test getTest(Long id){
        Test test = null;

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tests WHERE id = ?");
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                test = new Test(
                        resultSet.getLong("id"),
                        resultSet.getString("question1"),
                        resultSet.getString("question2"),
                        resultSet.getString("question3"),
                        resultSet.getString("question4"),
                        resultSet.getString("question5")
                );

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return test;
    }

    public static ArrayList<Test> getTests(){
        ArrayList<Test> tests = new ArrayList<>();

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tests");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                tests.add(new Test(
                        resultSet.getLong("id"),
                        resultSet.getString("question1"),
                        resultSet.getString("question2"),
                        resultSet.getString("question3"),
                        resultSet.getString("question4"),
                        resultSet.getString("question5")
                ));

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return tests;
    }

    public static boolean addStudentTests(StudentTest studentTest){
        int rows = 0;

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO students_tests (id, email, question1, question2, question3, question4, question5) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?)" +
                    "");

            statement.setString(1, studentTest.getEmail());
            statement.setString(2, studentTest.getQuestion1());
            statement.setString(3, studentTest.getQuestion2());
            statement.setString(4, studentTest.getQuestion3());
            statement.setString(5, studentTest.getQuestion4());
            statement.setString(6, studentTest.getQuestion5());

            rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }


    public static StudentTest getStudentTestsByEmail(String email){
        StudentTest studentTest = null;

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM students_tests WHERE email = ?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                studentTest = new StudentTest(
                        resultSet.getLong("id"),
                        resultSet.getString("email"),
                        resultSet.getString("question1"),
                        resultSet.getString("question2"),
                        resultSet.getString("question3"),
                        resultSet.getString("question4"),
                        resultSet.getString("question5")
                );

            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return studentTest;
    }

    public static boolean updateStudentSubmissionStatus(Students student){
        int rows = 0;

        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE students SET test_is_done = ?, score = ? " +
                    "WHERE id = ? ");

            statement.setInt(1, student.getTest_is_done());
            statement.setInt(2, student.getScore());
            statement.setLong(3, student.getId());

            rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;

    }

}
