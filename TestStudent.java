/*
 * Copyright (C) David P. Lopez - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited. 
 * Proprietary & Confidential
 * Written by: Lopez <DavidPLopez@Live.com>
 */
package teststudent;

import java.io.FileNotFoundException;

/**
 *
 * @author David P. Lopez
 */
public class TestStudent {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        StudentList studentList = new StudentList();
        
        studentList.readStudents();
        studentList.mergeSortStudents(studentList.students);
        // studentList.mergeSortStudents();
        
        
    }
    
}
