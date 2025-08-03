package com.example.studenthublogin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;

//User responsible for Student functionality is Ethan Rajkumar
public class Student extends User {
	int expected_grad_year;
	String major, email;

	public Student(String first_name, String last_name, String id, int in_expected_grad_year, String in_major, String in_email) {
		super(first_name, last_name, id);
		expected_grad_year = in_expected_grad_year;
        major = in_major;
		email = in_email;
	}


	public int GetGraduationYear()
	{
		return expected_grad_year;
	}

	public String GetMajor()
	{
		return major;
	}

	public String GetEmail()
	{
		return email;
	}

	public void SearchClass(int classID)
	{
		System.out.println("Successfully searched for class ID " + classID + ".");
	}

	public String AddClass(String title)
	{
		ResultSet rs;
		String query;

		try
		{
			query = "SELECT * FROM COURSE WHERE TITLE = '" + title + "';";
			rs = SqlExecuter.RunQuery("", query);

			if (rs.getString("TITLE") == null) {
				return "Invalid course ID detected.";
			}

			String students = rs.getString("STUDENTS");

			if (students == null)
			{
				students = "";
			}
			else if (students.contains(id)) {
				return "You are already enrolled in this course.";
			}
			else
			{
				String[] ids = students.split(" ");

				if (ids.length >= rs.getInt("SEATS"))
				{
					return "This course is currently full!";
				}
				else if (IsTimeConflict(rs.getInt("TIME"), rs.getString("DAYS").split(" "), rs.getString("SEMESTERS").split(" "), rs.getInt("YEAR")))
				{
					return "Time conflict detected.";
				}
			}

			students += " " + id;
			students = students.trim();

			query = "UPDATE COURSE SET STUDENTS = '" + students + "' WHERE TITLE = '" + title + "';";
			SqlExecuter.RunUpdate("", query);

			return "Successfully registered for course " + rs.getString("TITLE") + ".";
		}
		catch (SQLException e)
		{
			return "Database Error: " + e;
		}
	}

	private boolean IsTimeConflict(int time, String[] days, String[] semesters, int year)
	{
		// Query the database to pull up every course the student is currently registered for.
		String query = "SELECT * FROM COURSE WHERE STUDENTS LIKE '%" + id + "%';";
		ResultSet rs = SqlExecuter.RunQuery("", query);

		// Parse the 'time' field to get the start and end times of the desired course
		int startTime = time / 10000, endTime = time % 10000;
		// Holds values for the class we're checking for time conflicts with
		int currentTime, currentStartTime, currentEndTime, currentYear;
		String currentSemesters, currentDays;

		try {
			// For every course currently registered...
			while (rs.next()) {
				// Set values of current course to check for conflicts
				currentTime = rs.getInt("TIME");
				currentStartTime = currentTime / 10000;
				currentEndTime = currentTime % 10000;
				currentDays = rs.getString("DAYS");
				currentSemesters = rs.getString("SEMESTERS");
				currentYear = rs.getInt("YEAR");

				boolean overlappingSemester = false, overlappingDay = false;

				if (currentYear != year)
					continue;

				// For every semester in the desired class, check if a registered class runs on the same semester
				for (int i = 0; i < semesters.length; i++) {
					if (currentSemesters.contains(semesters[i])) {
						overlappingSemester = true;
						break;
					}
				}

				// If the classes don't run on the same semesters,  there can't be a conflict between the two
				if (!overlappingSemester)
					continue;

				// For every day in the desired class, check if a registered class runs on the same day
				for (int i = 0; i < days.length; i++) {
					if (currentDays.contains(days[i])) {
						overlappingDay = true;
						break;
					}
				}

				// If the classes don't run on the same days, there can't be a conflict between the two
				if (!overlappingDay)
					continue;

				// As a last check, test if the times overlap each other in some manner
				if (currentStartTime <= startTime && startTime <= currentEndTime)
					return true;
				else if (currentStartTime <= endTime && endTime <= currentEndTime)
					return true;
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
			return true;
		}

		// If we haven't found a time conflict in any currently registered class, there is no overall time conflict
		return false;
	}

	public String RemoveClass(String title)
	{
		ResultSet rs;
		String query;

		try {
			query = "SELECT * FROM COURSE WHERE TITLE = '" + title + "';";
			rs = SqlExecuter.RunQuery("", query);

			if (rs.getString("TITLE") == null) {
				return "Invalid course ID detected.";
			}

			String students = rs.getString("STUDENTS");

			if (!students.contains(id)) {
				return "You are not currently enrolled in this course.";
			}

			students = students.replace(id, "");
			students = students.replace(id + " ", "");
			students = students.trim();

			query = "UPDATE COURSE SET STUDENTS = '" + students + "' WHERE TITLE = '" + title + "';";
			SqlExecuter.RunUpdate("", query);

			return "Successfully unregistered for course " + rs.getString("TITLE") + ".";
		}
		catch (SQLException e)
		{
			return "Database error: " + e;
		}
	}

	public void PrintSchedule()
	{
		System.out.println(first_name + " " + last_name + "'s schedule:");

		String query = "SELECT * FROM COURSE WHERE STUDENTS LIKE '%" + id + "%';";
		ResultSet rs = SqlExecuter.RunQuery("", query);

		String title;
		int i = 0;
		try {
			while (rs.next()) {
				i++;
				title = rs.getString("TITLE");

				System.out.println("Class " + i + ": " + title);
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}

		if (i == 0)
			System.out.println("[Schedule is empty]");
	}

	public List<Course> GetSchedule()
	{
		List<Course> courses = new ArrayList<>();
		ResultSet rs = SqlExecuter.RunQuery("", "SELECT * FROM COURSE WHERE STUDENTS LIKE '%" + id + "%';");
		try {
			while (rs.next()) {
				courses.add(SqlSerializer.CourseFromSql(rs));
			}
		} catch (SQLException e) {
			System.out.println("Database error: " + e.getMessage());
		}

		return courses;
	}


}

