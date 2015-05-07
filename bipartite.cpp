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
		bool isBipartite();
};

Graph::Graph(int v)
{
	this->v = v;
	adj = new list<int>[v];
}

void Graph::addEdge(int v,int w)
{
	adj[v].push_back(w);
	adj[w].push_back(v);
}

bool Graph::isBipartite()
{
	int s = 0;
	int *color = new int[v];
	for(int i=0;i<v;i++)
	{
		color[i] = -1;
	}	
	color[0] = 0;
	list<int> queue;
	queue.push_back(0);
	while(!queue.empty())
	{
		int k = queue.front();
		int c = color[k];
		queue.pop_front();
		for(list<int>::iterator it=adj[k].begin();it!=adj[k].end();it++)
		{
			if(color[*it] == color[k])
			{
			//	printf("%d %d\n",*it,k);
				return false;
			}
			else
			{
				if(color[*it] == -1)
				{
					queue.push_back(*it);
					color[*it] = 1 - color[k];
				}
			}
		}
	}
	return true;
}

int main()
{
	Graph g(6);
	g.addEdge(0,1);
	g.addEdge(1,2);
//	g.addEdge(0,2);
	g.addEdge(3,4);
	g.addEdge(4,0);
	g.addEdge(2,3);
//	g.addEdge(5,0);
		
	printf("%d\n",g.isBipartite());	
	return 0;
}
