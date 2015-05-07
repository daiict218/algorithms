#include<stdio.h>
#include<algorithm>
#include<list>
using namespace std;
class Graph
{
	int v;
	list<int> *adj;
	public:
		Graph(int v);
		void addEdge(int v,int w);
		void bfs(int s);
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

void Graph::bfs(int s)
{
	bool *visited = new bool[v];
	for(int i=0;i<v;i++)
	{
		visited[i] = false;
	}
	
	list<int> queue;
	
	visited[s] = true;
	queue.push_back(s);
	while(!queue.empty())
	{
		s = queue.front();
		printf("%d ",s);
		queue.pop_front();
	
		list<int>::iterator i;
		for(i = adj[s].begin();i!=adj[s].end();i++)
		{
			if(!visited[*i])
			{
				queue.push_back(*i);
				visited[*i] = true;
			}
		}
	}
}

int main()
{
	Graph g(4);
	g.addEdge(0, 1);
	g.addEdge(0, 2);
	g.addEdge(1, 2);
	g.addEdge(2, 0);
	g.addEdge(2, 3);
	g.addEdge(3, 3);
	g.bfs(2);
	return 0;
}
