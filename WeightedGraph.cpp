#include<stdio.h>
#include<algorithm>
using namespace std;

struct Edge
{
	int src,dest,weight;
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

int main()
{
    int V = 4;  
    int E = 5;  
    struct Graph* graph = createGraph(V, E);
 
 
    // add edge 0-1
    graph->edge[0].src = 0;
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
    graph->edge[4].weight = 4;
 
 //   KruskalMST(graph);
 
    return 0;
}
