package com.rhwayfun.offer;

/**
 * 题目描述
 * 
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。 例如，当字符串为We Are Happy.则经过替换之后的
 * 字符串为We%20Are%20Happy。
 * 
 * @author Administrator
 *
 */
public class ReplaceSpace {
	public String replaceSpace(StringBuffer str) {
		String s = str.toString();
		//统计空格数
		int count = getBlankNum(str.toString());
		//获取原来字符串的长度
		int originalStrLen = s.toCharArray().length;
		//计算替换空格之后需要的长度
		int newStrLen = count * 2 + originalStrLen;
		char[] tempArray = new char[newStrLen];
		//把原字符串复制到tempArray数组中
		System.arraycopy(s.toCharArray(), 0, tempArray, 0, originalStrLen);
		int originalStrIndex = originalStrLen - 1;
		int newStrIndex = newStrLen -1;
		//当originalStrIndex == newStrIndex的时候替换完毕
		while(originalStrIndex >= 0 && originalStrIndex != newStrIndex){
			if(tempArray[originalStrIndex] == ' '){
				tempArray[newStrIndex--] = '0';
				tempArray[newStrIndex--] = '2';
				tempArray[newStrIndex--] = '%';
			}else{
				tempArray[newStrIndex--] = tempArray[originalStrIndex];
			}
			originalStrIndex--;
		}
		return new String(tempArray);
	}
	
	/**
	 * 计算空格数
	 * @param string
	 * @return
	 */
	private int getBlankNum(String string) {
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == ' '){
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String s = new ReplaceSpace().replaceSpace(new StringBuffer(""));
		System.out.println(s);
	}
}
