#include "stdio.h"    
#include "stdlib.h"   
#include "io.h"  
#include "math.h"  
#include "time.h"

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define MAXSIZE 100 /* 存储空间初始分配量 */

typedef int Status;	/* Status是函数的类型,其值是函数结果状态代码，如OK等 */ 

int F[100]; /* 斐波那契数列 */

/* 
	@param a: 要查找的数组
	@param n: 数组的长度
	@param key: 待查找的关键字
 */
int Binary_Search(int *a,int n,int key)
{
	int low,mid,high;
	low =1;					/* 定义开始查找的最低下标 */
	high = n;				/* 定义开始查找的最高下标 */
	
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
		else				/* 执行到这表示已经找到key */
			return mid;
	}
}

/*  插值查找算法 */
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
		else				/* 执行到这表示已经找到key */
			return mid;
	}
	return 0;
}

/* 斐波那契查找算法 */
int Fibonacci_Search(int *a,int n,int key)
{
	int low,mid,high,i,k=0;
	low =1;					/* 从第1位开始存储数据 */
	high =n;
	while(n>F[k]-1)			/* 找到n在斐波那契数列中的位置 */
		k++;
	for(i=n;i<F[k]-1;i++)	/* 用a[n]填充剩余的位置 */
		a[i]=a[n];

	while(low <= high)
	{
		mid = low +F[k-1]-1;/* 黄金分割点就是这么算的 */
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
			if(mid <=n)		/* 由于用数组的最后一个数进行了填充，所以mid的值可能超过n */
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
	printf("折半查找result:%d\n",result);
	result = Interpolation_Search(arr,10,62);
	printf("插值查找算法result:%d\n",result);

	F[0]=0;
	F[1]=1;
	for(i=2;i<100;i++)
		F[i]=F[i-1]+F[i-2];

	result = Fibonacci_Search(arr,10,59);
	printf("斐波那契查找result:%d\n",result);

	return 0;
}