#include "stdio.h"    
#include "stdlib.h"   
#include "io.h"  
#include "math.h"  
#include "time.h"

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define MAXSIZE 100 /* �洢�ռ��ʼ������ */

typedef int Status;	/* Status�Ǻ���������,��ֵ�Ǻ������״̬���룬��OK�� */ 

int F[100]; /* 쳲��������� */

/* 
	@param a: Ҫ���ҵ�����
	@param n: ����ĳ���
	@param key: �����ҵĹؼ���
 */
int Binary_Search(int *a,int n,int key)
{
	int low,mid,high;
	low =1;					/* ���忪ʼ���ҵ�����±� */
	high = n;				/* ���忪ʼ���ҵ�����±� */
	
	while(low <= high)
	{
		mid = (low+high)/2;
		if(a[mid] > key)
		{
			high = mid -1;
		}
		else if(a[mid] < key)
		{
			low = mid + 1;
		}
		else				/* ִ�е����ʾ�Ѿ��ҵ�key */
			return mid;
	}
}

/*  ��ֵ�����㷨 */
int Interpolation_Search(int *a,int n,int key)
{
	int low,mid,high;
	low = 1;
	high = n;

	while(low <= high)
	{
		mid = low + (key - a[low])/(a[high] - a[low]);
		if(a[mid] > key)
		{
			high = mid -1;
		}
		else if(a[mid] < key)
		{
			low = mid + 1;
		}
		else				/* ִ�е����ʾ�Ѿ��ҵ�key */
			return mid;
	}
	return 0;
}

/* 쳲����������㷨 */
int Fibonacci_Search(int *a,int n,int key)
{
	int low,mid,high,i,k=0;
	low =1;					/* �ӵ�1λ��ʼ�洢���� */
	high =n;
	while(n>F[k]-1)			/* �ҵ�n��쳲����������е�λ�� */
		k++;
	for(i=n;i<F[k]-1;i++)	/* ��a[n]���ʣ���λ�� */
		a[i]=a[n];

	while(low <= high)
	{
		mid = low +F[k-1]-1;/* �ƽ�ָ�������ô��� */
		if(a[mid] > key)
		{
			high = mid -1;
			k = k-1;
		}
		else if(a[mid] < key)
		{
			low = mid +1;
			k = k-2;
		}
		else
		{
			if(mid <=n)		/* ��������������һ������������䣬����mid��ֵ���ܳ���n */
				return mid;
			else
				return n;
		}
	}
	return 0;
}

int main()
{
	int i,result;
	int arr[MAXSIZE]={0,1,16,24,35,47,59,62,73,88,99};

	result = Binary_Search(arr,10,62);
	printf("�۰����result:%d\n",result);
	result = Interpolation_Search(arr,10,62);
	printf("��ֵ�����㷨result:%d\n",result);

	F[0]=0;
	F[1]=1;
	for(i=2;i<100;i++)
		F[i]=F[i-1]+F[i-2];

	result = Fibonacci_Search(arr,10,59);
	printf("쳲���������result:%d\n",result);

	return 0;
}