package com.Paul;
/**
 * 
 * @author pdmor
 *This is my interface which functions as a calculator for the Gradebook. The 4th methods are pretty self explanatory in nature. 
 *
 */
public interface StatsCalculator
{
	
	double calculateAverageGrade(); //calculates the average grade of the class based on the sum of all grades divided by size().
    double calculateHighestGrade();//finds the highest grade in the class
    double calculateLowestGrade();//finds the lowest grade in the class
    int calculateNumberOfStudents();//Grabs the size() of the class
}
