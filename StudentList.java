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
    protected ArrayList<Student> students = new ArrayList<>();
    
    // A Merge Sorted Array
    protected ArrayList<Student> sortedStudents = new ArrayList<>();
    
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
                //Retrieve input from file
                name = input.next();                
                grade1 = input.nextInt();               
                grade2 = input.nextInt();                
                grade3 = (input.nextInt());
                
                // Instantiate a new student with file input and add to ArrayList students
                students.add(new Student(name, grade1, grade2, grade3));
                
                // Populate the Student Average & Status fields!!!
                students.get(studentElement).computeAverage(students.get(studentElement));
                students.get(studentElement).computeStatus(students.get(studentElement));
                
                // Increment the loop control count to match ArrayList Element
                studentElement++;                
            }
            
            
            // just testing
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
    
    // implement Merge Sort algorithm to sort the students in descending order of average
    public void mergeSortStudents(List students){
        // If there is only 1 element in array than it is sorted
        if(students.size() == 1){
            System.out.println("ArrayList only contains 1 element");
        }
        
        // Divide the List to be Merge Sorted
        // Create 2 subLists a[0]..a[n/2] && a[n/2+1]..a[n]
        int n = (students.size() - 1);
        if(n > -1){
            List<Student> sList1 = students.subList(0, n);
            List<Student> sList2 = students.subList(n/2 + 1, n+1);
            
            

            // Recursively divide the lists into 2 halves until it 
            // cannot be divided any further
            mergeSortStudents(sList1);
            mergeSortStudents(sList2);

            /*
            System.out.println("List: " + sList1.get(0).getName());
            System.out.println("List: " + sList1.get(2).getName());
            System.out.println("List: " + sList2.get(0).getName());
            System.out.println("List: " + sList2.get(2).getName());
                    */
            
            while(sList1.size() > 0 && sList2.size() > 0){
                if(sList1.size() == 1){
                    sortedStudents.add(sList1.get(0));
                    sList1.remove(sList1.get(0));
                } else if(sList2.size() == 1){
                    sortedStudents.add(sList2.get(0));
                    sList2.remove(sList2.get(0));
                } else{
                    if(sList1.get(0).getAverage() > sList2.get(0).getAverage()){
                    sortedStudents.add(sList2.get(0));
                    sList2.remove(sList2.get(0));
                    } else{
                        sortedStudents.add(sList1.get(0));
                        sList1.remove(sList1.get(0));
                    } 
                }        
            }
            
            while(sList1.size() > 0){
                sortedStudents.add(sList1.get(0));
                sList1.remove(sList1.get(0));
            }
            
            while(sList2.size() > 0){
                sortedStudents.add(sList2.get(0));
                sList1.remove(sList2.get(0));
            }    
        }
        else{
            System.out.println("MergeSortingComplete");
        }
    }
    
    // prompt the user for an output file name and write contents of students
    // to the output file in the following format:
    // Name   Grade1   Grade2   Grade3   Average   Status
    // Dave    100.0    100.0    100.0    100.0    Passing
    public void writeStudents(){
        
    }   
}
