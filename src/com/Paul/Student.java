package com.Paul;

import java.util.Objects;
/**
 * This is the student class. It has a construct and getters and setters. I created this class so I can store all the info
 * from my CSV as a student object. 
 * @author pdmor
 *
 */
public class Student
{
    private String firstName;
    private String lastName;
    private int age;
    private String major;
    private double grade;
	/**
	 * 
	 * @param firstName First Name of the Student
	 * @param lastName Last Name of the Student
	 * @param age Age of the Student
 	 * @param major Major of the Student
	 * @param grade Grade of the Student
	 */
    
    public Student(String firstName, String lastName, int age, String major, double grade)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.major = major;
		this.grade = grade;
	}
/**
 * 
 * @return firstName returns firstname of the student
 */

	public String getFirstName()
	{
		return firstName;
	}
/**
 * 
 * @param firstName sets first name of the student 
 */

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
/**
 * 
 * @return lastName of the student 
 */

	public String getLastName()
	{
		return lastName;
	}
/**
 * 
 * @param lastName sets lastName of the student 
 */

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

/**
 * 
 * @return age of the student 
 */
	public int getAge()
	{
		return age;
	}
/**
 * 
 * @param age sets age of the student 
 */

	public void setAge(int age)
	{
		this.age = age;
	}
/**
 * 
 * @return major of the student 
 */

	public String getMajor()
	{
		return major;
	}

/**
 * 
 * @param major sets major of the student 
 */
	public void setMajor(String major)
	{
		this.major = major;
	}

/**
 * 
 * @return grade of the student 
 */
	public double getGrade()
	{
		return grade;
	}

/**
 * 
 * @param grade sets grade of the student 
 */
	public void setGrade(double grade)
	{
		this.grade = grade;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(age, major, firstName, grade, lastName);
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
		Student other = (Student) obj;
		return age == other.age && Objects.equals(major, other.major)
				&& Objects.equals(firstName, other.firstName)
				&& Double.doubleToLongBits(grade) == Double.doubleToLongBits(other.grade)
				&& Objects.equals(lastName, other.lastName);
	}


	@Override
	public String toString()
	{
		return "Student [First Name: " + firstName + ", Last Name: " + lastName + ", Age: " + age + ", Major: "
				+ major + ", Grade: " + grade + "]";
	}
    
    
	
    
    

}
