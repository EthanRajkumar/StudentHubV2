package com.example.studenthublogin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlSerializer {
    public static String StudentToSql(Student student, String tableName) {
        String sp = ", ";
        return "INSERT INTO STUDENT VALUES (" +
                "'" + student.GetID() + "'" + sp +
                "'" + student.GetFirstName() + "'" + sp +
                "'" + student.GetLastName() + "'" + sp +
                student.GetGraduationYear() + sp +
                "'" + student.GetMajor() + "'" + sp +
                "'" + student.GetEmail() + "');";
    }

    public static Student StudentFromSql(ResultSet rs)
    {
        try {
            String name = rs.getString("NAME"),
                    surname = rs.getString("SURNAME"),
                    id = rs.getString("ID"),
                    major = rs.getString("MAJOR"),
                    email = rs.getString("EMAIL");

            int gradYear = rs.getInt("GRADYEAR");

            return new Student(name, surname, id, gradYear, major, email);
        } catch (SQLException e) {
            System.out.println("Error parsing Student object. " + e);
            return null;
        }
    }

    public static Instructor InstructorFromSql(ResultSet rs)
    {
        try {
            String name = rs.getString("NAME"),
                    surname = rs.getString("SURNAME"),
                    id = rs.getString("ID"),
                    title = rs.getString("TITLE"),
                    major = rs.getString("DEPT"),
                    email = rs.getString("EMAIL");

            int yearOfHire = rs.getInt("HIREYEAR");

            return new Instructor(name, surname, id, title, yearOfHire, major, email);
        } catch (SQLException e) {
            System.out.println("Error parsing Instructor object. " + e);
            return null;
        }
    }

    public static Admin AdminFromSql(ResultSet rs)
    {
        try {
            String name = rs.getString("NAME"),
                    surname = rs.getString("SURNAME"),
                    id = rs.getString("ID"),
                    title = rs.getString("TITLE"),
                    office = rs.getString("OFFICE"),
                    email = rs.getString("EMAIL");

            return new Admin(name, surname, id, title, office, email);
        } catch (SQLException e) {
            System.out.println("Error parsing Admin object. " + e);
            return null;
        }
    }

    public static String InstructorToSql(Instructor instructor, String tableName) {
        String sp = ", ";
        return "INSERT INTO INSTRUCTOR VALUES ('" +
                instructor.GetID() + "'" + sp +
                "'" + instructor.GetFirstName() + "'" + sp +
                "'" + instructor.GetLastName() + "'" + sp +
                "'" + instructor.GetTitle() + "'" + sp +
                instructor.GetYearOfHire() + sp +
                "'" + instructor.GetDepartment() + "'" + sp +
                "'" + instructor.GetEmail() + "');";
    }

    public static String AdminToSql(Admin admin, String tableName) {
        String sp = ", ";
        return "INSERT INTO ADMIN VALUES (" +
                "'" + admin.GetID() + "'" + sp +
                "'" + admin.GetFirstName() + "'" + sp +
                "'" + admin.GetLastName() + "'" + sp +
                "'" + admin.GetTitle() + "'" + sp +
                "'" + admin.GetOffice() + "'" + sp +
                "'" + admin.GetEmail() + "');";
    }

    public static String CourseToSql(Course course, String tableName) {
        String sp = ", ", days_string = "", semesters_string = "";
        String[] days = course.getDays(), semesters = course.getSemesters();

        for (String day : days) {
            if (day == "")
                continue;

            days_string += (day + " ");
        }

        days_string = days_string.trim();

        for (String semester : semesters) {
            if (semester == "")
                continue;
            semesters_string += (semester + " ");
        }

        semesters_string = semesters_string.trim();

        return "INSERT INTO COURSE VALUES (" +
                course.getCRN() + sp +
                "'" + course.getTitle() + "'" + sp +
                "'" + course.getDepartment() + "'" + sp +
                course.getTime() + sp +
                "'" + days_string + "'" + sp +
                "'" + semesters_string + "'" + sp +
                course.getYear() + sp +
                course.getCredits() + sp +
                course.getSeats() + sp + "'', '');";
    }

    public static Course CourseFromSql(ResultSet rs)
    {
        try {
            int id = Integer.parseInt(rs.getString("CRN"));
            String title = rs.getString("TITLE");
            String department = rs.getString("DEPARTMENT");
            String instructorID = rs.getString("INSTRUCTOR");
            int time = Integer.parseInt(rs.getString("TIME"));
            String[] days = new String[]{rs.getString("DAYS")},
                    semesters = new String[]{rs.getString("SEMESTERS")};
            int year = Integer.parseInt(rs.getString("YEAR")),
                    credits = Integer.parseInt(rs.getString("CREDITS")),
                    seats = Integer.parseInt(rs.getString("SEATS"));

            return new Course(title, department, id, time, days, semesters, year, credits, seats, instructorID);
        } catch (SQLException e) {
            System.out.println("Error parsing Course object. " + e);
            return null;
        }
    }
}