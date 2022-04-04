package com.ob.finalassessment;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * @author Abisheikha
 * ---Final Assessment: Student details management system---
 */
public class Main {
	public static void main(String[] args) {
		ArrayList<Student> students= new ArrayList<>();
		students.add(new Student(1, "Abi", 98.3f, "Mathematics"));
		students.add(new Student(2, "Neha", 67.1f, "Data Structures"));
		students.add(new Student(3, "Anu", 77.3f, "Operating Systems"));
		students.add(new Student(4, "Arthi", 99f, "Chemistry"));
		students.add(new Student(5, "Anitha", 87.8f, "Physics"));
		boolean exit=true;
		Scanner input = new Scanner(System.in);
		while (exit) {
			System.out.println("\n-----Student Management System-----");
			System.out.println();
			System.out.println("\tEnter your choice: ");
			System.out.println("1. Add a student\n2. Edit Student information\n"
					+ "3. Delete Student information\n"
					+ "4. Display list of Students\n5. Get a Student information\n"
					+ "6. Display Sorted list of Students\n7.Exit");
			int choice = input.nextInt();
			Student stud = new Student();
			switch (choice) {
			case 1: stud.addStudent(students);
					System.out.println("Student information is added..\n");
					break;
			case 2: stud.editStudent(students);
					break;
			case 3: stud.deleteStudent(students);
					break;
			case 4: stud.listOfStudents(students);
					break;
			case 5: stud.getStudentInfo(students);
					break;
			case 6: stud.sortedStudentList(students);
					break;
			case 7: System.out.println("\t************************");
					exit=false;
					break;
			default: System.out.println("Enter valid choice");
			}
		}
	}
}
