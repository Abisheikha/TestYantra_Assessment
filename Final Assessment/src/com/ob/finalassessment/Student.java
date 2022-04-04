package com.ob.finalassessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Abisheikha
 */
public class Student implements Comparable<Student> {
	int id;
	String name;
	float marks;
	String course;

	public Student() {
	}

	Scanner sc = new Scanner(System.in);

	public Student(int id, String name, float marks, String course) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.course = course;
	}
/*-------Add a student information---------*/
	public void addStudent(ArrayList<Student> students) {
		System.out.println("Add Student information");
		while (true) {
			id = getStudId();
			boolean bool = IsIdPresent(id, students);
			if (bool) {
				System.out.println("The student id is already present.Enter some other id..");
			} else
				break;
		}
		System.out.println("Enter Student name: ");
		name = sc.next();
		System.out.println("Enter Student marks: ");
		marks = sc.nextFloat();
		System.out.println("Enter Student course: ");
		course = sc.next();
		Student Student = new Student(id, name, marks, course);
		students.add(Student);
		System.out.println(Student);
	}
	/*-------Edit a student information---------*/
	public void editStudent(ArrayList<Student> students) {
		if (students.size() > 0) {
			while (true) {
				id = getStudId();
				boolean bool = IsIdPresent(id, students);
				if (bool) {
					System.out.println("\tEnter your choice to edit: ");
					System.out.println(
							"1.Edit Student ID\n2. Edit Student name\n3. Edit Student Marks\n4. Edit Student Course\n");
					int ch = sc.nextInt();
					switch (ch) {
					case 1:
						for (Student std : students){ // Editing student ID
							if (std.id == id) {
								while (true) {
									System.out.println("Enter new Student Id: ");
									id = sc.nextInt();
									boolean bool1 = IsIdPresent(id, students);
									if (bool1) {
										System.out.println("The student id is already present.Enter some other id..");
									} else {
										std.id = id;
										break;
									}
								}
								System.out.println("Student information is edited..\n");
								System.out.println(std);
								return;
							}
						}
					case 2:
						for (Student std : students) { // Editing student name
							if (std.id == id) {
								System.out.println("Enter new student name: ");
								std.name = sc.next();
								System.out.println("Student information is edited..\n");
								System.out.println(std);
								return;
							}
						}
					case 3:
						for (Student std : students) { // Editing student marks
							if (std.id == id) {
								System.out.println("Enter new student marks: ");
								std.marks = sc.nextFloat();
								System.out.println("Student information is edited..\n");
								System.out.println(std);
								return;
							}
						}
					case 4:
						for (Student std : students) { // Editing student course
							if (std.id == id) {
								System.out.println("Enter new student course: ");
								std.course = sc.next();
								System.out.println("Student information is edited..\n");
								System.out.println(std);
								return;
							}
						}
					default:
						System.out.println("Enter valid choice...");
						return;
					}
				} else {
					System.out.println("The Student Id is not found..Enter some other id!");

				}
			}
		} else {
			System.out.println("The list is empty");
		}
	}
	/*-------Delete a student information---------*/
	public void deleteStudent(ArrayList<Student> students) {
		if (students.size() > 0) {
			while (true) {
				id = getStudId();
				boolean bool = IsIdPresent(id, students);
				if (bool) {
					for (Student std : students) {
						if (std.id == id) {
							students.remove(std);
							System.out.println("Student information is deleted..\n");
							listOfStudents(students);
							return;
						}
					}
				} else
					System.out.println("The given Student Id is not found! Enter some other Id..");
			}
		} else {
			System.out.println("Can't be deleted as the list is empty");
		}
	}
	/*-------Displaying students list---------*/
	public void listOfStudents(ArrayList<Student> students) {
		if (students.size() > 0) {
			Iterator<Student> iterator = students.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} else {
			System.out.println("The list is empty");
		}
	}
	/*-------Displaying particular student information---------*/
	public void getStudentInfo(ArrayList<Student> students) {
		if (students.size() > 0) {
			while (true) {
				id = getStudId();
				boolean bool = IsIdPresent(id, students);
				if (bool) {
					for (Student std : students) {
						if (std.id == id) {
							System.out.println("Student ID: " + std.id + "\n" + "Student name: " + std.name + "\n"
									+ "Student marks: " + std.marks + "\n" + "Student Course: " + std.course + "\n");
							return;
						}
					}
				} 
				else{
					System.out.println("The student id is not found.!Enter some other id..");
				}
			}
			
		} else {
			System.out.println("The list is empty");
		}
	}
	/*-------Displaying students list in sorted order---------*/
	public void sortedStudentList(ArrayList<Student> students) {
		if (students.size() > 0) {
		System.out.println("\tEnter your choice: ");
		System.out.println(
				"1. Sort list by Student ID\n2. Sort list by Student name\n3. Sort list by Student Marks\n4. Sort list by Student Course\n");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			Collections.sort(students);
			break;
		case 2:
			Collections.sort(students, new SortByName());
			break;
		case 3:
			Collections.sort(students, new SortByMarks());
			break;
		case 4:
			Collections.sort(students, new SortByCourse());
			break;
		default:
			System.out.println("Enter valid choice");
			break;
		}
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		}
		else {
			System.out.println("The list is empty");
		}
	}
	/*-------Checking whether the student id is present in list---------*/
	public static boolean IsIdPresent(int sid, ArrayList<Student> students) {
		for (Student std : students) {
			if (std.id == sid) {
				return true;
			}
		}
		return false;
	}
	/*-------Get student id as input---------*/
	public int getStudId() {
		int sid;
		System.out.println("Enter Student Id:");
		return (sid = sc.nextInt());

	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + ", course=" + course + "]";
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.id - o.id;
	}

}
