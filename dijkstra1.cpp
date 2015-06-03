#include<stdio.h>
#include<stdlib.h>
#include<limits.h>
#include<algorithm>
#include<vector>
#include<string.h>
using namespace std;

// Heap node
struct heap_node
{
	int vertex_no; 
	int vertex_value;	//vertex value is the distance from source.(src)
};


//Making a comparator to make min heap in the dijkstra algorithm.
bool compare(struct heap_node a,struct heap_node b)
{
	if(a.vertex_value > b.vertex_value)
		return true ;
	return false;
}
 
//Node of a graph.
class node
{
	public:
		int to,weight;
		node(int to,int weight);
};

//Node Constructor
node::node(int to,int weight)
{
	this->to = to;
	this->weight = weight;
}


//Graph Class
class Graph
{
	int V,E;
	vector<node> *adj;
	public :
		Graph(int V,int E);
		void addEdge(int v,int w,int weight);
		void dijkstra(int src,int V);
};

Graph::Graph(int V,int E)
{
	this->V = V;
	this->E = E;
	adj = new vector<node>[V];
}

void Graph::addEdge(int v,int w,int weight)
{
	node x(w,weight);
	adj[v].push_back(x);
	node y(v,weight);
	adj[w].push_back(y);
}

void Graph::dijkstra(int src,int V)
{
	struct heap_node nodex[V];
	for(int i=0;i<V;i++)
	{
		nodex[i].vertex_value = INT_MAX;
		nodex[i].vertex_no = i;
	}
	bool visited[V];
	memset(visited,false,sizeof(visited));
	nodex[src].vertex_value = 0;
	make_heap(nodex,nodex+V,compare);
	int val = 0;
	//As we have set vertex_value(distance from source) of the source node to 0,We are left with V-1 vertices. So, we will run a for loop. 
	visited[src] = true;
	for(int i=0;i<V-1;i++)	
	{
//		printf("%d\n",nodex[0].vertex_value);
		pop_heap(nodex,nodex+V-i,compare);
		//This will extract the minimum from the heap and set it to the last position. 
		int cur = V-i-1;
//		printf("%d %d %d\n",cur,nodex[cur].vertex_value,nodex[cur].vertex_no);
		int u = nodex[cur].vertex_no;
		vector<node>::iterator it;
		visited[u] = true;
//		printf("%d\n",u);
		for(it = adj[u].begin() ; it != adj[u].end() ; it++)
		{
			node v = *it;
			for(int j=0 ; j<V ; j++)
			{
				if(nodex[j].vertex_no == v.to)
				{
					val = j;
					break;
				}
			}
			if(!visited[v.to] && nodex[cur].vertex_value!=INT_MAX && nodex[val].vertex_value > nodex[cur].vertex_value + v.weight)
			{
				nodex[val].vertex_value = nodex[cur].vertex_value + v.weight;
			}
		}
		make_heap(nodex,nodex+V-i-1,compare);
	}
	printf("The shortest distance from %d\n",src);
	for(int i= 0 ; i<V ; i++)
	{
		printf("node %d : %d\n",nodex[i].vertex_no,nodex[i].vertex_value);
	}
}

int main()
{
	int V,E;
//	scanf("%d%d",&V,&E);
	Graph g(9,14);
	g.addEdge(0,1,4);
	g.addEdge(0,7,8);
	g.addEdge(1,2,8);
	g.addEdge(1,7,11);
	g.addEdge(2,3,7);
	g.addEdge(2,8,2);
	g.addEdge(2,5,4);
	g.addEdge(3,4,9);
	g.addEdge(3,5,14);
	g.addEdge(4,5,10);
	g.addEdge(5,6,2);
	g.addEdge(6,7,1);
	g.addEdge(6,8,6);
	g.addEdge(7,8,7);
	g.dijkstra(0,9);
	return 0;
}
