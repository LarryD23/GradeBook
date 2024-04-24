//Paul Morgan 
//4-25-23
package com.Paul;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Driver {
    public static void main(String[] args) 
    {
        Map<String, Student> studentMap = new HashMap<>();//creates a Map that is a String as key and Student as value
        try (BufferedReader br = new BufferedReader( //creates a reader that will read the .csv file
				new FileReader("src\\com\\Paul\\GradeBook.csv"))) //csv file that is read
        {
            br.readLine();  //skips first column
        	String line;
            while ((line = br.readLine()) != null) 
            {
                String[] tokens = line.split(",");  //makes sure file is read correctly and creates tokens object
                String firstName = tokens[0];		//each of these tokens[] is used to store the corresponding column from the csv
                String lastName = tokens[1];
                int age = Integer.parseInt(tokens[2]);
                String course = tokens[3];
                double grade = Double.parseDouble(tokens[4]) / 100.0;
                Student student = new Student(firstName, lastName, age, course, grade); //create student object that stores all the information we just got from csv
                String key = firstName + " " + lastName;     //creates key for Map that is student firstName and lastName
                studentMap.put(key, student);				//puts key and value on studentMap with the String and Student
            }
        } 
       
        
        catch (IOException e) //Exception to handle file input problems 
        {
            System.out.println("Error reading file: ");
            
        }
        
        catch (NumberFormatException ne) //I added this exception because my Header Columns were being read as ints and to make sure that stopped, I added this, so I knew what was up!
        {
        	System.out.println("Number Formatting Error: ");
        	
        }

        List<Student> studentList = studentMap.values().stream() //Use Java API streams to go through my Map and sort the List based on Grades from Highest to Lowest
                .sorted(Comparator.comparing(Student::getGrade).reversed())
                .collect(Collectors.toList());
        		studentList.forEach(System.out::println);
        		
        		System.out.println(); //add some space between my all my outputs 
        		

        		Course course = new Course(studentList); //create new Course object that takes a studentList.

        		for (Student student : studentList)  //iterate through the studentList and call the determineCourse() to place students in their respective class
        		{
        		    String enrolledCourse = course.determineCourse(student);
        		    System.out.println(student.getFirstName() + " " + student.getLastName() + " is enrolled in " + enrolledCourse);
        		    System.out.println();
        		}

        
     



        // calculate statistics: Here I call all the methods from my Interface and Course classes. 
         System.out.println("Average grade: " + String.format("%.2f", course.calculateAverageGrade()));
         System.out.println("Minimum grade: " + course.calculateLowestGrade());
         System.out.println("Maximum grade: " + course.calculateHighestGrade());
         System.out.println("Number of students: " + course.calculateNumberOfStudents());
    }
}

