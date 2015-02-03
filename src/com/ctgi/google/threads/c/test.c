#include<stdlib.h>
#include<stdio.h>
#include<pthread.h>
#define SIZE 10
int A[SIZE];
int B[SIZE];

void merge(int,int,int);
void mergeSort(int,int);
void printArray();

struct threadArgs
{
	int tId;
	int p;
	int r;
};


void merge(int p, int q, int r)
{
	int i,j,index;
	i=p;
	j=q+1;
	index=p;
	while(i<=q && j<=r)
	{
		if(A[i] < A[j])
		{
			B[index++] = A[i];
			i++;
		}
		else
		{
			B[index++] = A[j];
			j++;
		}
	}
	if(i==q+1)
	{
		while(j<=r)
		{
			B[index++] = A[j++];
		}
	}
	else
	{
		while(i<=q)
		{
			B[index++] = A[i++];
		}
	}
	for(int i=p;i<=r;i++)
	{
		A[i] = B[i];
	}
	
}

void mergeSort(int p, int r)
{
	if(p<r)
	{	
		int q = (p+r)/2;
		mergeSort(p,q);
		mergeSort(q+1,r);
		merge(p,q,r);
	}
}

void printArray()
{
	for(int i=0;i<SIZE;i++)
	{
		printf("%d\t",A[i]);
	}
	printf("\n");
}

void *foo(void* tArgs)
{
	struct threadArgs* t = (struct threadArgs*) tArgs;
	int tId = t->tId;
	int p = t->p;
	int r = t->r;
	mergeSort(p,r);
	return NULL; 
}

int main()
{
	pthread_t pt[2];
	struct threadArgs** tArgs;
	tArgs = (struct threadArgs**) malloc(2*sizeof(struct threadArgs*));
	for(int i=0;i<2;i++)
	{
		tArgs[i] = (struct threadArgs*) malloc(sizeof(struct threadArgs));
		tArgs[i]->tId=i;
	}
	tArgs[0]->p=0;
	tArgs[0]->r=(SIZE/2)-1;
	tArgs[1]->p=(SIZE/2);
	tArgs[1]->r=SIZE-1;	
	for(int i=0;i<SIZE;i++)
  	{
  	      A[i]=SIZE-i;
  	}
	printArray();
	for(int i=0;i<2;i++)
	{
		pthread_create(&pt[i],NULL,foo,(void*) tArgs[i]);
		pthread_join(pt[i],NULL);
  	}
	//merge(0,SIZE/2-1,SIZE-1);
	//mergeSort(0,SIZE-1);
	printArray();
}

