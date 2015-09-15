package com.rhwayfun.algorithm.tree;

import java.io.File;

/**
 * 
 * <p>Title:ListDir</p>
 * <p>Description:遍历一个路径下的所有文件夹以及文件</p>
 * @author rhwayfun
 * @date Aug 18, 2015 5:19:36 PM
 * @version 1.0
 */
public class ListDir {

	public static void main(String[] args) {
		ListDir listDir = new ListDir();
		int level = 0;
		String path = "D:/Program Files/apache-maven-3.3.3";
		File file = new File(path);
		listDir.listFile(file, level);
	}

	public void listFile(File file,int level){
		String s ="";
		for (int i=0;i<level;i++) {
			s+=" ";
		}
		File[] files = file.listFiles();
		for (File f : files) {
			System.out.println(s + f.getName());
			if(f.isDirectory()){
				listFile(f,++level);
			}
		}
	}
}
