#include<stdio.h>
#include<algorithm>
#include<limits.h>
#include<math.h>

using namespace std;

int MAXN;
int MAXLG;

struct node
{
	int rank[2];
	int index;
};


//Sort the L struct. If rank of current half is same, the sort by rank of next half and if it's not same then sort by the current half itself.
int cmp(struct node a,struct node b)
{
	return a.rank[0] == b.rank[0] ? (a.rank[1] < b.rank[1] ? 1 : 0) : (a.rank[0] < b.rank[0]) ? 1 :0;
}

int main()
{
	printf("Enter the string\n");
	char c;
	char *s = new char[100001];
	int i = 0;
	while((c = getchar())!='\n')
	{
		s[i++] = c;
	}
	s[i] = '\0';

	/*
	*
	Important : MAXN is length of string which will serve as column of the P array and MAXLG will serve as the row of the P array. in first row of P array, 
	we will be storing the rank of suffixes in 's' starting at position 'j' (some column). In the second row of P array, we will be storing the rank of suffix 
	starting at position 'j' and 2^i elements compared. 'i' being the index of row of P array 
	*/

	MAXN = i;
	MAXLG = log(MAXN)/log(2) + 1;
			
	int P[MAXLG][MAXN];
	//printf("%d %d\n",MAXN,MAXLG);
	
	// In the first row of P-matrix, we will be storing the rank of suffix starting from 'j' and total 2^i elements (i = 0) for first row.
		

	/*This struct will store 3 entries. rank of the current half of the suffix, rank of the next half of the suffix and the index of suffix.*/
	struct node L[MAXN];

	for(int i=0;i<MAXN;i++)
		P[0][i] = s[i]-'a';

	//Step will fill the P-matrix and count will have count of upto how many elements we have compared. At every increment, we will double the count 
	int step = 1;
	int count = 1;

	for(count=1,step = 1;count < MAXN; count *= 2,step++)
	{
		for(int i=0;i<MAXN;i++)
		{
			//This will store the rank of the current half.
			L[i].rank[0] = P[step-1][i];
			//This will store the rank of the next half
			L[i].rank[1] = i + count < MAXN ? P[step-1][i+count] : -1;
			//This will store the index of the suffix
			L[i].index = i;			
		}
		sort(L,L+MAXN,cmp);

		//This loop will set the rank of suffixes. upto length 2^count
		for(int i=0;i<MAXN;i++)
		{
			// if both ranks of L[i+1] is same, then P[step][L[i].index] = P[step][L[i-1].index], else the rank will be i.
			if(i == 0)
			{
				P[step][L[i].index] = 0;
			}
			else
			{
				if(L[i].rank[0] == L[i-1].rank[0] && L[i].rank[1] == L[i-1].rank[1])
				{
					P[step][L[i].index] = P[step][L[i-1].index];
				}
				else
				{
					P[step][L[i].index] = i;
				}
			}
		}
		/*for(int i=0;i<MAXLG;i++)
		{
			for(int j=0;j<MAXN;j++)
			{
				printf("%d ",P[i][j]);
			}
			printf("\n");
		}*/
	}
	for(int i=0;i<MAXN;i++)
	{
		printf("%d ",P[MAXLG-1][i]);
	}
	printf("\n");
	return 0;
}
