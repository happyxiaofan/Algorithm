package com.rhwayfun.offer;

/**
 * ��Ŀ����
 * 
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20���� ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮���
 * �ַ���ΪWe%20Are%20Happy��
 * 
 * @author Administrator
 *
 */
public class ReplaceSpace {
	public String replaceSpace(StringBuffer str) {
		String s = str.toString();
		//ͳ�ƿո���
		int count = getBlankNum(str.toString());
		//��ȡԭ���ַ����ĳ���
		int originalStrLen = s.toCharArray().length;
		//�����滻�ո�֮����Ҫ�ĳ���
		int newStrLen = count * 2 + originalStrLen;
		char[] tempArray = new char[newStrLen];
		//��ԭ�ַ������Ƶ�tempArray������
		System.arraycopy(s.toCharArray(), 0, tempArray, 0, originalStrLen);
		int originalStrIndex = originalStrLen - 1;
		int newStrIndex = newStrLen -1;
		//��originalStrIndex == newStrIndex��ʱ���滻���
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
	 * ����ո���
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
