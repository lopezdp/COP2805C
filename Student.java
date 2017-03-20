/*
 * Copyright (C) David P. Lopez - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited. 
 * Proprietary & Confidential
 * Written by: Lopez <DavidPLopez@Live.com>
 */
package teststudent;

/**
 *
 * @author David P. Lopez
 */
public class Student {
    
    // Student Class Attributes
    private String name, status;
    private int grade1, grade2, grade3;
    private double average;
    
    // Student Class Constructors
    public Student(){
        // default constructor
    }
    
    // Overloaded Constructor
    public Student(String name, int grade1, int grade2, int grade3)
    {
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }
    
    // Static Method to compare two Student Averages
    public static int compareTo(Student student1, Student student2){
        if(student1.getAverage() > student2.getAverage()){
            return 1; // return 1 for student1
        } else if (student2.getAverage() > student1.getAverage()){
            return 2; // return 2 for student2
        }
        else{
            return 0; // return 0 if tie
        }
    }
    
    // Setter Methods
    public void setName(String name){
        this.name = name;
    }
    
    public void setGrade1(int grade1){
        this.grade1 = grade1;
    }
    
    public void setGrade2(int grade2){
        this.grade2 = grade2;
    }
    
    public void setGrade3(int grade3){
        this.grade3 = grade3;
    }
    
    // Accessor Methods
    public String getName(){
        return this.name;
    }
    
    public int getGrade1(){
        return this.grade1;
    }
    
    public int getGrade2(){
        return this.grade2;
    }
    
    public int getGrade3(){
        return this.grade3;
    }
    
    public double getAverage(){
        return this.average;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    // Method to compute the average
    public void computeAverage(Student student){
        double avg = (student.grade1 + student.grade2 + student.grade3) / 3.0;
        this.average = avg;
    }
    
    // Method to compute the status of each student
    public void computeStatus(Student student){
        if(this.getAverage() < 70){
            this.status = "Failing";
        }else {
            this.status = "Passing";
        }
    }
}
