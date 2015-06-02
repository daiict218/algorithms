#include<stdio.h>
#include<algorithm>
using namespace std;

struct Edge
{
	int src,dest;
};

struct Graph
{
	int V,E;
	struct Edge *edge;	//Array of edges 
};

struct Graph* createGraph(int V,int E)
{
	struct Graph* graph = (struct Graph*) malloc(sizeof(struct Graph));	//equivalent to Garph g = new Graph();	, memory allocation of graph 
	graph->V = V;
	graph->E = E;

	graph->edge = (struct Edge *)malloc(graph->E * sizeof(struct Edge));	//equivalent to g.edge = new Edge();	, memory allocation of Edge
}

int find(int *arr,int i)
{
	while(i!=arr[i])
	{
		arr[i] = arr[arr[i]];
		i  = arr[i];
	}
	return i;
}

void Union(int u,int v,int *arr)
{
	int x = find(arr,u);
	int y = find(arr,v);
	if(x!=y)
	{
		arr[y] = x;
	}
}

bool isCycle(struct Graph *g)
{
	int *arr = new int[g->V];
	for(int i=0;i<g->V;i++)
	{
		arr[i] = i;
	}
	for(int v=0;v<g->E;v++)
	{
		int x = find(arr,g->edge[v].src);
		int y = find(arr,g->edge[v].dest);
//		printf("%d %d\n",x,y);
		if(x == y)
		{
			return true;
		}
		Union(x,y,arr);
	}
	return false;
}

int main()
{
/*    int V = 4;  
    int E = 5;  
    struct Graph* graph = createGraph(V, E);*/
 
 
    // add edge 0-1
    /*graph->edge[0].src = 0;
    graph->edge[0].dest = 1;
    graph->edge[0].weight = 10;
 
    // add edge 0-2
    graph->edge[1].src = 0;
    graph->edge[1].dest = 2;
    graph->edge[1].weight = 6;
 
    // add edge 0-3
    graph->edge[2].src = 0;
    graph->edge[2].dest = 3;
    graph->edge[2].weight = 5;
 
    // add edge 1-3
    graph->edge[3].src = 1;
    graph->edge[3].dest = 3;
    graph->edge[3].weight = 15;
 
    // add edge 2-3
    graph->edge[4].src = 2;
    graph->edge[4].dest = 3;
    graph->edge[4].weight = 4;*/
	
/* Let us create following graph
         0
        |  \
        |    \
        1-----2 */
    struct Graph* graph = createGraph(3, 3);
 
    // add edge 0-1
    graph->edge[0].src = 0;
    graph->edge[0].dest = 1;
 
    // add edge 1-2
    graph->edge[1].src = 1;
    graph->edge[1].dest = 2;
 
    // add edge 0-2
    graph->edge[2].src = 0;
    graph->edge[2].dest = 2;
 
    if (isCycle(graph))
        printf( "Graph contains cycle" );
    else
        printf( "Graph doesn't contain cycle" );
 
    return 0;
     
 //   KruskalMST(graph);
 
    return 0;
}
