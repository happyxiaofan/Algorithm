package com.rhwayfun.algorithm.linkedlist;

public class StudentStrategy implements Strategy {

	public int compare(Object e1, Object e2) {
		if(e1 instanceof Student && e2 instanceof Student){
			//�ѱȽ϶���תΪѧ������
			Student s1 = (Student) e1;
			Student s2 = (Student) e2;
			return s1.getSID().compareTo(s2.getSID());
		}else{
			return e1.toString().compareTo(e2.toString());
		}
	}

	public boolean equal(Object e1, Object e2) {
		//�ж������Ƚ϶����Ƿ���ѧ������
		if(e1 instanceof Student && e2 instanceof Student){
			//�ѱȽ϶���תΪѧ������
			Student s1 = (Student) e1;
			Student s2 = (Student) e2;
			return s1.getSID().equals(s2.getSID());
		}else{
			return false;
		}
	}

}
