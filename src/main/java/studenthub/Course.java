package studenthub;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Arrays;

public class Course {
    String[] days, semesters;

    public SimpleStringProperty Title, Department, DaysString, SemestersString;
    public SimpleIntegerProperty CRN, Year, Credits, Seats, Time;

    public Course(String in_title,  String in_department, int in_CRN, int in_time, String[] in_days, String[] in_semesters, int in_year, int in_credits, int in_seats){
        Title = new SimpleStringProperty(in_title);
        Department = new SimpleStringProperty(in_department);
        CRN = new SimpleIntegerProperty(in_CRN);
        Time = new SimpleIntegerProperty(in_time);
        Year = new SimpleIntegerProperty(in_year);
        Credits = new SimpleIntegerProperty(in_credits);
        Seats = new SimpleIntegerProperty(in_seats);

        SemestersString = new SimpleStringProperty("");
        DaysString = new SimpleStringProperty("");

        setSemesters(in_semesters);
        setDays(in_days);
    }

    public String getTitle() {
        return Title.get();
    }

    public String getDepartment() { return Department.get(); }

    public int getTime() {
        return Time.get();
    }

    public String[] getDays() {
        return days;
    }

    public String[] getSemesters() {
        return semesters;
    }

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

    public void setTitle(String in_title) { Title.set(in_title); }

    public void setDepartment(String in_department) { Department.set(in_department); }

    public void setTime(int in_time) { Time.set(in_time); }

    public void setDays(String[] in_days) {
        days = in_days;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < days.length; i++)
        {
            if (i > 0)
                sb.append(", ");

            if (days[i].length() > 0)
                sb.append(days[i]);
        }
    }

    public void setSemesters(String[] in_semesters) {
        semesters = in_semesters;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < semesters.length; i++)
        {
            if (i > 0)
                sb.append(", ");

            if (semesters[i].length() > 0)
                sb.append(semesters[i]);
        }
    }

    public void setYear(int in_year) {
        Year.set(in_year);
    }

    public void setCredits(int in_credits) {
        Credits.set(in_credits);
    }

    public void setSeats(int in_seats) { Seats.set(in_seats); }

    public void PrintAll() {
        System.out.println("ID: " + CRN + " Title: " + getTitle() + " Department: " + getDepartment() + " Time: " + getTime() + " Days: " +
                Arrays.toString(days) + " Semesters: " + Arrays.toString(semesters) + " Year: " + getYear() + " Credits: " + getCredits() + " Seats:" + getSeats());
    }
}
