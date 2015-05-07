#include<stdio.h>
#include<algorithm>
#include<iostream>
#include<list>
using namespace std;

class Graph
{
	int V;		//no. of vertices
	list<int> *adj;	//pointer to the array of lists.
//	void DFSutil(int v, bool *visited);
	public:
		Graph(int V);	//Constructor
		void addEdge(int v, int w);
//		void DFSutil(int v,bool visited);
		void DFS(int v);	
		void DFSutil(int v, bool *visited);
};

Graph::Graph(int V)
{
	this->V = V;
	adj = new list<int>[V];		//array of lists
}

void Graph::addEdge(int v,int w)
{
	adj[v].push_back(w);		//Add w to v's list
}

void Graph::DFSutil(int v,bool *visited)
{
	visited[v] = true;
	printf("%d ",v);
	
	for(list<int>::iterator it = adj[v].begin();it!=adj[v].end();++it)
	{
		if(!visited[*it])
		{
			DFSutil(*it,visited);
		}
	}
}

void Graph::DFS(int v)
{
	bool *visited = new bool[V];
	for(int i=0;i<V;i++)
	{
		visited[i] = false;
	}
	
	DFSutil(v,visited);
}

int main()
{
	Graph g(4);
	g.addEdge(0,1);
	g.addEdge(0,2);
	g.addEdge(1, 2);
	g.addEdge(2, 0);
    	g.addEdge(2, 3);
    	g.addEdge(3, 3);
		
	g.DFS(2);
	return 0;
}
