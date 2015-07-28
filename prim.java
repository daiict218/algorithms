import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
class obj
{
	int dest;
	int weight;
	obj(int dest,int weight)
	{
		this.dest = dest;
		this.weight = weight;
	}
}

class obj2
{
	int src;
	int weight;
	obj2(int src,int weight)
	{
		this.src = src;
		this.weight = weight;
	}
}

class cmp implements Comparator<obj2>
{
	public int compare(obj2 a,obj2 b)
	{
		return a.weight - b.weight;
	}
}

class main
{
	public static int n,e;
	public static ArrayList<obj> list[];
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of nodes");
		n = input.nextInt();
		list = new ArrayList[n+1];
		System.out.println("Enter number of edges");
		e = input.nextInt();
		System.out.println("Enter all edges one by one (weight, source, destination)");
		for(int i=0;i<e;i++)
		{
			int w = input.nextInt();
			int s = input.nextInt();
			int d = input.nextInt();
			if(list[s] == null)
				list[s] = new ArrayList<obj>();
			if(list[d] == null)
				list[d] = new ArrayList<obj>();
			list[s].add(new obj(d,w));
			list[d].add(new obj(s,w));
		}
		System.out.println(prim(1));
	}

	//it takes x as argument as which marks starting of a random index
	public static int prim(int x)
	{
		PriorityQueue<obj2> Q = new PriorityQueue<obj2>(10,new cmp());
		int mincost = 0;
		obj2 o = new obj2(x,0);
		Q.add(o);
		obj2 temp;
		boolean marked[] = new boolean[n+1];
		while(!Q.isEmpty())
		{
			temp = Q.poll();
			int y = temp.src;
			if(marked[y])
			{
				continue;
			}
			mincost += temp.weight;
			marked[y] = true;
			for(int i=0;i<list[y].size();i++)
			{
				obj h = list[y].get(i);
				if(!marked[h.dest])
				{
					Q.add(new obj2(list[y].get(i).dest,list[y].get(i).weight));	
				}
			}
		}
		return mincost;
	}
}
