package com.rhwayfun.algorithm.sort;


/**
 * 
 * <p>Title:BinaryInsertionSort</p>
 * <p>Description:�۰��������</p>
 * @author rhwayfun
 * @date Sep 7, 2015 1:53:29 PM
 * @version 1.0
 */
public class BinaryInsertionSort {
    public static void main(String[] args) {
        int[] a={49,38,65,97,176,213,227,49,78,34,12,164,11,18,1};
        System.out.println("����֮ǰ��");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        
        //���ֲ�������
        sort(a);
        System.out.println();
        System.out.println("����֮��");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

	/**
	 * 
	 * @Description: ʱ�临�Ӷ�ΪO(n^2)
	 * @param a   
	 * @return void  
	 * @throws
	 */
    private static void sort(int[] a) {
       for(int i = 1; i < a.length; i++){
		   int tmp = a[i];
		   int low = 0;
		   int high = i - 1;
		   int mid = 0;
		   int j = 0;	
		   /*���ڶ��ֲ����㷨���۰���ң���low��ֵ����high��ֵʱ�Ϳ���
		   * ȷ���±Ƚϵ�����Ҫ�����λ�ã���Ϊlow����high + 1�����Է���
		   * ��low��ֵ����high��ֵ��low��ֵʼ�ձ�high��ֵ��1
		   */
		   while(low <= high){
			   mid = (low + high)/2;
			   if(tmp <= a[mid]){
				   high  =  mid - 1;
			   }else{
				   low = mid + 1;
			   }
		   }
		   //ȷ���±Ƚϵ�����Ҫ�����λ�ú�ֻ��Ҫ��λ��low������high+1������һ��λ��
		   for(j = i-1; j>=low; j--){
			   a[j+1] = a[j];
		   }
		   //�ѿճ���λ�õ�ֵ����
		   a[j+1] = tmp;
	   }
    }
}