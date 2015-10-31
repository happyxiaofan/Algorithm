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

/* �ݹ���Ҷ�����������Ƿ����key */
/* @param T: ��������� */
/* @param key: Ҫ���ҵ�Ԫ�� */
/* @param f: ָ��T��˫�� */
/* @param *p: ������ҳɹ�����ָ��pָ���Ԫ�ؽ�㣬������true */
/* �������ʧ�ܣ���ָ��pָ����ʵ����һ��Ԫ�ؽ�㣬������false */
Status BiTree_Search(BiTree T,int key,BiTree f,BiTree *p)
{
	if(!T)
	{
		*p = f;
		return FALSE;
	}
	else if(T->data == key)				/*  ���ҳɹ� */
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

/* ����Ԫ��������������� */
/* @param T: ��������� */
/* @param key: Ҫ�����Ԫ�ؽ�� */
Status BiTree_Insert(BiTree *T,int key)
{
	BiTree p,s;
	if(!BiTree_Search(*T,key,NULL,&p))		/*  ���Ҳ��ɹ� */
	{
		s = (BiTree)malloc(sizeof(BiTNode));
		s->data = key;
		s->lchild = s->rchild = NULL;
		if(!p)								/* ָ��pָ��NULL,˵����һ�ÿ��� */
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

/* ʹ�ô�ɾ������ǰ����Ϊ���滻�� */
Status Delete(BiTree *p)
{
	BiTree q,s;
	if((*p)->rchild == NULL)				/* ������Ϊ�գ��ؽ������� */
	{
		q = *p;
		*p = (*p)->lchild;
		free(q);
	}
	else if((*p)->lchild == NULL)			/* ������Ϊ�գ��ؽ������� */
	{
		q = *p;
		*p = (*p)->rchild;
		free(q);
	}
	else									/* �������������������� */
	{
		q = *p;
		s = (*p)->lchild;
		while(s->rchild)					/* ת����������������Ϊ���ڵ��ҵ���ɾ������ֱ��ǰ�� */
		{
			q = s;
			s = s->rchild;
		}
		(*p)->data = s->data;				/* ѭ��������s�Ѿ��Ǵ�ɾ�����p��ֱ��ǰ���ˣ��ѽ���ֵ�滻��ǰ����ֵ */
		if(q!=*p)
			q->rchild = s->lchild;
		else
			q->lchild = s->lchild;
		free(s);
	}
	return TRUE;

}

/* ɾ�������������Ϊkey��� */
Status Delete(BiTree *T,int key)
{
	if(!*T)									/*  ����ǿ�������ôɾ��ʧ�� */
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