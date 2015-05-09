#include<stdio.h>
#include<algorithm>
#include<list>
#include<stack>
using namespace std;

class Graph
{
	int v;
	list<int> *adj;
	public:
		Graph(int v);
		void addEdge(int v,int w);
		void fillOrder(int v, bool *visited, stack<int> &Stack);
		void dfsUtil(int v, bool *visited);
		void printSCCs();
		Graph getTransponse();
};

Graph::Graph(int v)
{
	this->v = v;
	adj = new list<int>[v];
}

void Graph::addEdge(int v,int w)
{
	adj[v].push_back(w);
}

void Graph::dfsUtil(int v, bool *visited)
{
	visited[v] = true;
	printf("%d ",v);
	for(list<int>::iterator it = adj[v].begin();it!=adj[v].end();it++)
	{
		if(!visited[*it])
		{
			dfsUtil(*it,visited);
		}
	}
}

void Graph::fillOrder(int v, bool *visited,stack<int> &Stack)
{
	visited[v] = true;
	for(list<int>::iterator it=adj[v].begin();it!=adj[v].end();it++)
	{
		if(!visited[*it])
		{
			fillOrder(*it,visited,Stack);
		}
	}
	Stack.push(v);
}

Graph Graph::getTransponse()
{
	Graph g(v);
	for(int i=0;i<v;i++)
	{
		for(list<int>::iterator it = adj[i].begin();it!=adj[i].end();it++)
		{
			g.adj[*it].push_back(i);
		}
	}
	return g;
}

void Graph::printSCCs()
{
//	printf("hello");
	bool *visited = new bool[v];
	for(int i=0;i<v;i++)
	{
		visited[i] = false;
	}

	stack<int> Stack;
	for(int i=0;i<v;i++)
	{
		if(!visited[i])
		{
			fillOrder(i,visited,Stack);
		}
	}
//	printf("hello");	
	Graph gr = getTransponse();
	for(int i=0;i<v;i++)
	{
		visited[i] = false;
	}
	
	while(!Stack.empty())
	{
		int v = Stack.top();
		Stack.pop();
		if(!visited[v])
		{
			gr.dfsUtil(v,visited);
			printf("\n");
		}
	}
}

int main()
{
	Graph g(5);
	g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
 
        g.printSCCs();	
	return 0;
}
