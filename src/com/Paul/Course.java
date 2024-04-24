package com.Paul;
/**
 * Course class where I implement my interface and create my methods that will be used in the driver class. 
 */
import java.util.List;
import java.util.Objects;
/**
 * 
 * @author pdmor
 *
 */
public class Course implements StatsCalculator {
    private String name;
    private List<Student> students;
/**
 * 
 * @param studentList creates a List that takes a Student object
 * @param name Name of Course
 */ 
 
/**
 * 
 * @param studentList Constructor that is just List<> of Students
 */
    public Course(List<Student> studentList)
	{
		this.students = studentList;
	}
/**
 * 
 * @param adds student
 */
	public void addStudent(Student student) 
	{
        students.add(student);
    }
/**
 * 
 * @param removes student 
 */
    public void removeStudent(Student student) 
    {
        students.remove(student);
    }
/**
 * 
 * @return returns a List of students
 */
    public List<Student> getStudents() 
    {
        return students;
    }
/**
 * 
 * @return gets Course name
 */
    public String getName() 
    {
        return name;
    }
/**
 * 
 * @param name sets Name of course 
 */
    public void setName(String name) 
    {
        this.name = name;
    }
/** 
 * 
 */
	@Override
	public int hashCode()
	{
		return Objects.hash(name, students);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(name, other.name) && Objects.equals(students, other.students);
	}

	@Override
	public String toString()
	{
		return "Course [name=" + name + ", students=" + students + "]";
	}
	/**
	 * Calculates the average grade of the class
	 * @return the class average grade.
	 */
	@Override
	public double calculateAverageGrade() 
	{
	    int numStudents = students.size(); //gets size of the student List
	    if (numStudents == 0)
	    {								//this was to check that the List wasn't empty
	        return 0.0;
	    } 
	    else 
	    {
	        double totalGrade = 0.0;		// initializes variable, iterates through list, adds grades of each student
	        
	        for (Student student : students) 
	        {
	            totalGrade += student.getGrade();
	        }
	        return totalGrade / numStudents; //divide sum of all student grades by student size()
	    }
	}

	/**
	 * gets the highest grade from the Students List
	 * @return the highest grade from the list.
	 */
	@Override
	public double calculateHighestGrade() 
	{
	    if (students.isEmpty()) //made just in case the list is empty
	    {
	        return 0.0;
	    }
	    double maxGrade = students.get(0).getGrade(); //gets initial grade of student and sets as maxgrade
	    for (int i = 1; i < students.size(); i++)    //iterates through list 
	    {
	        double grade = students.get(i).getGrade(); //gets next grade and if grade is higher than maxGrade sets that as the new maxGrade
	        if (grade > maxGrade) 
	        {
	            maxGrade = grade;
	        }
	    }
	    return maxGrade;
	}
/**
 * gets lowest grade from student list
 * @return the lowest Grade
 */
	
	@Override
	public double calculateLowestGrade() 
	{
	    double minGrade = students.get(0).getGrade();//gets initial grade of student and sets as mingrade
	    for (Student student : students) 			//for each loop that iterates through list and checks if each grade is lower than current minGrade
	    											//if so it sets current grade as minGrade
	    {
	        if (student.getGrade() < minGrade) 
	        {
	            minGrade = student.getGrade();
	        }
	    }
	    return minGrade;
	}

/**
 * Just a quick method that grabs the size of the student list. 
 */
	@Override
	public int calculateNumberOfStudents()
	{
		return students.size(); 
	}
    /**
     * 
     * @param student takes a student object and returns a string
     * @return String 
     * This method sorts the students into two different classes based on the average grade of the class. 
     */
	public String determineCourse(Student student) 
	{
	    double studentGrade = student.getGrade(); //gets grade from student object
	    double averageGrade = calculateAverageGrade(); //uses the calculateAverageGrade to find class average
	    if (studentGrade > averageGrade) 				//compares studentGrade to class Average.
	    {
	        return "JavaI";								//higher than average go here
	    } 
	    else 
	    {
	        return "KinderMath";						//lower than average go here
	    }
	}

}

