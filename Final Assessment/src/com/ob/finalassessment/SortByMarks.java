package com.ob.finalassessment;

import java.util.Comparator;

/**
* @author Abisheikha
*/
public class SortByMarks implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return (int)( (int)o2.marks-(int)o1.marks);
	}
}
