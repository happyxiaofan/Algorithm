#include "stdio.h"    
#include "stdlib.h"   
#include "io.h"  
#include "math.h"  
#include "time.h"

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0

typedef int Status;

typedef struct BiTNode
{
	int data;
	struct BiTNode *lchild,*rchild;
}BiTNode,*BiTree;

/* 递归查找二叉查找树中是否存在key */
/* @param T: 二叉查找树 */
/* @param key: 要查找的元素 */
/* @param f: 指向T的双亲 */
/* @param *p: 如果查找成功，则指针p指向该元素结点，并返回true */
/* 如果查找失败，则指针p指向访问的最后一个元素结点，并返回false */
Status BiTree_Search(BiTree T,int key,BiTree f,BiTree *p)
{
	if(!T)
	{
		*p = f;
		return FALSE;
	}
	else if(T->data == key)				/*  查找成功 */
	{
		*p = T;
		return TRUE; 
	}
	else if(T->data > key)
	{
		return BiTree_Search(T->lchild,key,f,p);
	}
	else
	{
		return BiTree_Search(T->rchild,key,f,p);
	}
} 

/* 插入元素至二叉查找树中 */
/* @param T: 二叉查找树 */
/* @param key: 要插入的元素结点 */
Status BiTree_Insert(BiTree *T,int key)
{
	BiTree p,s;
	if(!BiTree_Search(*T,key,NULL,&p))		/*  查找不成功 */
	{
		s = (BiTree)malloc(sizeof(BiTNode));
		s->data = key;
		s->lchild = s->rchild = NULL;
		if(!p)								/* 指针p指向NULL,说明是一棵空树 */
		{
			*T = s;
		}
		else if(key < p->data)
			p->lchild = s;
		else
			p->rchild = s;
		return TRUE;
	}
	return FALSE;
}

/* 使用待删除结点的前驱作为其替换者 */
Status Delete(BiTree *p)
{
	BiTree q,s;
	if((*p)->rchild == NULL)				/* 右子树为空，重接左子树 */
	{
		q = *p;
		*p = (*p)->lchild;
		free(q);
	}
	else if((*p)->lchild == NULL)			/* 左子树为空，重接右子树 */
	{
		q = *p;
		*p = (*p)->rchild;
		free(q);
	}
	else									/* 既有左子树又有右子树 */
	{
		q = *p;
		s = (*p)->lchild;
		while(s->rchild)					/* 转左子树，以左子树为根节点找到待删除结点的直接前驱 */
		{
			q = s;
			s = s->rchild;
		}
		(*p)->data = s->data;				/* 循坏结束，s已经是待删除结点p的直接前驱了，把结点的值替换成前驱的值 */
		if(q!=*p)
			q->rchild = s->lchild;
		else
			q->lchild = s->lchild;
		free(s);
	}
	return TRUE;

}

/* 删除二叉查找树中为key结点 */
Status Delete(BiTree *T,int key)
{
	if(!*T)									/*  如果是空树，那么删除失败 */
		return FALSE;
	else
	{
		if((*T)->data == key)
			return Delete(T);
		else if((*T)->data > key)
			return Delete(&(*T)->lchild,key);
		else
			return Delete(&(*T)->rchild,key);
	}
}



int main()
{
	int i;
	BiTree T;
	int a[10]={62,88,58,47,35,73,51,99,37,93};

	for(i =0;i<10;i++)
		BiTree_Insert(&T, a[i]);
	
	return 0;
}