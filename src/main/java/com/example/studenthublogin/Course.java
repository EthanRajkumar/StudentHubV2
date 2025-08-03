package com.example.studenthublogin;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class Course {
    String[] days, semesters, studentIDs;
    String instructorID;
    public SimpleStringProperty Title, Department, DaysString, SemestersString, StudentIDsString, Instructor;
    public SimpleIntegerProperty CRN, Year, Credits, Seats, Time;

    public Course(String in_title,  String in_department, int in_CRN, int in_time, String[] in_days, String[] in_semesters, int in_year, int in_credits, int in_seats, String instructorID, String[] studentIDs) {
        Title = new SimpleStringProperty(in_title);
        Department = new SimpleStringProperty(in_department);
        CRN = new SimpleIntegerProperty(in_CRN);
        Time = new SimpleIntegerProperty(in_time);
        Year = new SimpleIntegerProperty(in_year);
        Credits = new SimpleIntegerProperty(in_credits);
        Seats = new SimpleIntegerProperty(in_seats);

        SemestersString = new SimpleStringProperty("");
        DaysString = new SimpleStringProperty("");
        StudentIDsString = new SimpleStringProperty("");
        Instructor = new SimpleStringProperty("");

        setSemestersString(in_semesters);
        setDaysString(in_days);
        setInstructor(instructorID);
        setStudentIDsString(studentIDs);
    }

    public String getTitle() {
        return Title.get();
    }

    public String getDepartment() { return Department.get(); }

    public int getTime() {
        return Time.get();
    }

    public String getDaysString() {
        return DaysString.get();
    }

    public String getSemestersString() {
        return SemestersString.get();
    }

    public String getStudentIDsString() { return StudentIDsString.get(); }

    public String[] getDays() { return days; }

    public String[] getSemesters() { return semesters; }

    public int getCRN() {
        return CRN.get();
    }

    public int getYear() {
        return Year.get();
    }

    public int getCredits() {
        return Credits.get();
    }

    public int getSeats() {
        return Seats.get();
    }

    public String getInstructor() { return Instructor.get(); }

    public void setCRN(int in_crn) { CRN.set(in_crn); }

    public void setTitle(String in_title) { Title.set(in_title); }

    public void setDepartment(String in_department) { Department.set(in_department); }

    public void setTime(int in_time) { Time.set(in_time); }

    public void setDaysString(String[] in_days) {
        days = in_days;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < days.length; i++)
        {
            if (i > 0)
                sb.append(", ");

            if (days[i].length() > 0)
                sb.append(days[i]);
        }

        DaysString.set(sb.toString());
    }

    public void setSemestersString(String[] in_semesters) {
        semesters = in_semesters;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < semesters.length; i++)
        {
            if (i > 0)
                sb.append(", ");

            if (semesters[i].length() > 0)
                sb.append(semesters[i]);
        }

        SemestersString.set(sb.toString());
    }

    public void setStudentIDsString(String[] in_studentIDs) {
        studentIDs = in_studentIDs;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < studentIDs.length; i++)
        {
            if (i > 0)
                sb.append(", ");

            if (studentIDs[i].length() > 0)
                sb.append(studentIDs[i]);
        }

        StudentIDsString.set(sb.toString());
    }

    public void setYear(int in_year) {
        Year.set(in_year);
    }

    public void setCredits(int in_credits) {
        Credits.set(in_credits);
    }

    public void setSeats(int in_seats) { Seats.set(in_seats); }

    public void setInstructor(String id)
    {
        instructorID = id;
        ResultSet rs = SqlExecuter.RunQuery("", "SELECT * FROM INSTRUCTOR WHERE ID='" + instructorID + "'");

        try {
            if (rs.next())
                Instructor.set(rs.getString("SURNAME") + ", " + rs.getString("NAME"));
            else
                Instructor.set("- None -");
        }
        catch (SQLException e)
        {
            System.out.println(e);
            Instructor.set("- None -");
        }
    }

    public void PrintAll() {
        System.out.println("ID: " + CRN + " Title: " + getTitle() + " Department: " + getDepartment() + " Time: " + getTime() + " Days: " +
                Arrays.toString(days) + " Semesters: " + Arrays.toString(semesters) + " Year: " + getYear() + " Credits: " + getCredits() + " Seats:" + getSeats());
    }
}
