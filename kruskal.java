import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

class main
{
	//Indexing from 1
	public static int arr[];
	public static int n,e;
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter total number of nodes");
		n = input.nextInt(); 
		arr = new int[n+1];
		for(int i=1;i<=n;i++)
		{
			arr[i]	 = i;
		}
		System.out.println("Enter total number of edges");
		e = input.nextInt();
		int array[][] = new int[e][3];
		System.out.println("Enter all edges one by one: (weight, vertex a, vertex b)");
		for(int i=0;i<e;i++)
		{
			for(int j=0;j<3;j++)
			{
				array[i][j] = input.nextInt();
			}
		}

		Arrays.sort(array,new Comparator<int[]>()
		{
			public int compare(int a[],int b[])
			{
				return a[0]-b[0];
			}
		});
		
		System.out.println();
		for(int i=0;i<e;i++)
                {
                        for(int j=0;j<3;j++)
                        {
                                System.out.print(array[i][j]+" ");
                        }
			System.out.println();
                }

		//Result
		System.out.println(kruskal(array));
		
		//Union Array
		for(int i=1;i<=n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static int kruskal(int array[][])
	{
		int mincost = 0;
		for(int i=0;i<e;i++)
		{
			int x = array[i][1];
			int y = array[i][2];
			int cost = array[i][0];
			if(find(x) != find(y))
			{
				mincost += cost;
				union(x,y);
			}
		}
		return mincost;		
	}	

	public static int find(int i)
	{
		while(i != arr[i])
		{
			i = arr[i];
			arr[i] = arr[arr[i]];
		}
		return i;
	}
	
	public static void union(int i,int j)
	{
		int a = find(i);
		int b = find(j);
//		arr[b] = arr[a];
		if(a != b)
		{
			arr[b] = a;
		}
	}
}
