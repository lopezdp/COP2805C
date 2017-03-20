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
import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class StudentList {
    
    // An array list of students
    ArrayList<Student> students = new ArrayList<>();
    
    // method that prompts the user for an input file name
    // and it reads the contents of the input file into students
    // Expected File Input:
    // FirstName | Grade1 | Grade2 | Grade3
    public void readStudents() throws FileNotFoundException{
        // Create new instance of a fileChooser
        JFileChooser chooser = new JFileChooser();
        
        // Allow user to only select .txt files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Select Text Files (.txt) Only", "txt");
        chooser.setFileFilter(filter);
        
        // Display chooser dialog menu
        int returnVal = chooser.showOpenDialog(null);
        
        // Notify User of the selected file & parse file
        if(returnVal == JFileChooser.APPROVE_OPTION){
            // Store path to file
            String path = chooser.getSelectedFile().getPath();
            // Store filename
            File file = new File(path);
            // Notify user of selected file
            System.out.println("You have chosen to open the following file: " 
            + file.toString());
            
            // Use scanner to access file contents
            Scanner input = new Scanner(file);
            
            // Define file delimeter using "\\" plus the pipe delimeter
            // 1st back slash tells compiler to ignore 2nd
            // Together they make 1 backslash that is used to escape the
            // Pipe "|" symbol in the regex engine
            // Using regex combine with \\s to match any whitespace 
            // charachter at end
            input.useDelimiter("(\\|)|(\\s)");
            
            // Declare temp variables to hold data from file
            String name;
            int grade1, grade2, grade3;
            
            // Loop control count
            int studentElement = 0;
            
            // Loop through file contents and save each object as an element in ArrayList
            while(input.hasNext()){
                name = input.next();
                System.out.println("Name: " + name);
                
                grade1 = input.nextInt();
                System.out.println("g1: " + grade1);
                
                grade2 = input.nextInt();
                System.out.println("g2: " + grade2);
                
                grade3 = (input.nextInt());
                System.out.println("g3: " + grade3);
                
                // Instantiate a new student and add to ArrayList students
                students.add(new Student(name, grade1, grade2, grade3));
                
                // Populate the Student Average & Status fields!!!
                students.get(studentElement).computeAverage(students.get(studentElement));
                students.get(studentElement).computeStatus(students.get(studentElement));
                
                // Increment the loop control count to match ArrayList Element
                studentElement++;
                
            }
            
            
            
            System.out.println("Name: " + students.get(0).getName());
            System.out.println("Avg: " + students.get(0).getAverage());
            System.out.println("Status: " + students.get(0).getStatus());
            
            System.out.println("Name: " + students.get(1).getName());
            System.out.println("Avg: " + students.get(1).getAverage());
            System.out.println("Status: " + students.get(1).getStatus());
            
            System.out.println("Name: " + students.get(2).getName());
            System.out.println("Avg: " + students.get(2).getAverage());
            System.out.println("Status: " + students.get(2).getStatus());
            
        }

        
    }
    
    // implement mergeSort algorithm to sort the students in descending order of average
    public void sortStudents(){
        
    }
    
    // prompt the user for an output file name and write contents of students
    // to the output file in the following format:
    // Name   Grade1   Grade2   Grade3   Average   Status
    // Dave    100.0    100.0    100.0    100.0    Passing
    public void writeStudents(){
        
    }
    
}
