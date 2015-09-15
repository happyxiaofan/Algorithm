package com.rhwayfun.algorithm.linkedlist;

import org.junit.Before;
import org.junit.Test;

public class StudentStrategyTest {
	
	private StudentStrategy studentStrategy;
	@Before
	public void setUp() throws Exception {
		studentStrategy = new StudentStrategy();
	}

	@Test
	public void testCompare() {
		//创建两个学生对象
		Student s1 = new Student();
		Student s2 = new Student();
		String s3 = "BHYD78";
		s1.setSID("BHYD78");
		s2.setSID("BHYD78");
		
		System.out.println(studentStrategy.compare(s1, s3));
	}

	@Test
	public void testEqual() {
		//创建两个学生对象
		Student s1 = new Student();
		Student s2 = new Student();
		s1.setSID("BHYD78");
		s2.setSID("BHYD78");
		
		boolean isEqual = studentStrategy.equal(s1, s2);
		System.out.println(isEqual);
	}

}
