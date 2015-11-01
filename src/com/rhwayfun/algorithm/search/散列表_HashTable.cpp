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

#define SUCCESS 1
#define UNSUCCESS 0
#define HASHSIZE 12 /* 定义散列表长为数组的长度 */
#define NULLKEY -32768 

typedef int Status;

typedef struct		/* 散列表的定义 */
{
	int *elem;
	int count;
}HashTable;

int m = 0;			/* 散列表的长度 */

Status InitHashTable(HashTable *H)		/* 散列表初始化 */
{
	int i;
	m = HASHSIZE;
	H->count = m;
	H->elem = (int *)malloc(m*sizeof(int));
	for(i=0;i<m;i++)
		H->elem[i]=NULLKEY;
	return OK;
}

int Hash(int key)
{
	return key % m;
}

void InsertHash(HashTable *H,int key)	/* 往散列表中插入元素 */
{
	int addr = Hash(key);
	while(H->elem[addr]!=NULLKEY)		/* 如果不等于NULLKEY说明该位置已经被其他元素占用了，发生了冲突 */
	{
		addr = (addr+1)%m;			/* 进行线性探测*/
	}
	H->elem[addr] = key;
}

Status SearchHash(HashTable H,int key,int *addr)	/* 在散列表中查找元素key */
{
	*addr = Hash(key);
	while(H.elem[*addr]!=key)
	{
		*addr = (*addr+1)%m;
		if(H.elem[*addr] == NULLKEY || *addr == Hash(key))	/* 如果为NULLKEY或者回到原点，说明查找失败 */
			return UNSUCCESS;
	}
	return SUCCESS;
}

int main()
{
	int arr[HASHSIZE]={12,67,56,16,25,37,22,29,15,47,48,34};
	int i,p,key,result;
	HashTable H;

	key = 39;

	InitHashTable(&H);
	for(i=0;i<m;i++)
		InsertHash(&H,arr[i]);

	result = SearchHash(H,key,&p);
	if(result)
		printf("查找%d的地址为：%d\n",key,p);
	else
		printf("查找%d失败\n",key);

	for(i=0;i<m;i++)
	{
		key = arr[i];
		SearchHash(H,key,&p);
		printf("查找%d的地址：%d\n",key,p);
	}
	return 0;
}

