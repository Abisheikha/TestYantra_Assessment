package com.ob.finalassessment;

import java.util.Comparator;

/**
* @author Abisheikha
*/
public class SortByName implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}
}
