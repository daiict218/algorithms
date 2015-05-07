#include<stdio.h>
#include<algorithm>
#include<list>
using namespace std;
class Graph
{
	int v;
	list<int> *adj;
	int *indegree;
	public:
		Graph(int v);
		void addEdge(int v,int w);
		void topologicalSort();
};

Graph::Graph(int v)
{
	this->v = v;
	indegree = new int[v];
	for(int i=0;i<v;i++)
	{
		indegree[i] = 0;
	}
	adj = new list<int>[v];
}

void Graph::addEdge(int v,int w)
{
	adj[v].push_back(w);
	indegree[w]++;
}

void Graph::topologicalSort()
{
	list<int> queue;
	int counter = 0;
	for(int i=0;i<v;i++)
	{
		if(indegree[i] == 0)
		{
			queue.push_back(i);
		}
	}
		
	while(!queue.empty())
	{
		int s = queue.front();
		printf("%d ",s);
		queue.pop_front();
		counter++;
		list<int>::iterator it;
		for(it=adj[s].begin();it!=adj[s].end();it++)
		{
			if(--indegree[*it] == 0)
			{
				queue.push_back(*it);
			}
		}
	}
	if(counter != v)
	{
		printf("Graph has a cycle\n");
	}
}

int main()
{
	Graph g(6);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);
	g.topologicalSort();
	return 0;
}
