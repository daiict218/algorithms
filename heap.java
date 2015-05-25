import java.util.Scanner;
class heap
{
	public int root;
	int n;
	int arr[];

	public heap(int n)
	{
		this.n = n;
		this.root = 0;
		arr = new int[n];
	}
	
	public int getLeft(int i)
	{
		return 2*i + 1;
	}
		
	public int getRight(int i)
	{
		return 2*i+2;
	}
	
	public int getParent(int i)
	{
		return (i-1)/2;
	}

	public int getMin()
	{
		return arr[0];
	}

	public void heapify(int i)
	{
		int left = getLeft(i);
		int right = getRight(i);
		int smallest = i;
		if(left < n)
		{
			if(arr[left] < arr[i])
			{
				smallest = left;
			}
		}	
		if(right < n)
		{
			if(arr[right] < arr[smallest])
			{
				smallest = right;
			}
		}
		if(i!=smallest)
		{
			int temp = 0;
			temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
			heapify(smallest);
		}
	}
	
	public void makeHeap(int x[])
	{
		for(int i=0;i<n;i++)
		{				
			arr[i] = x[i];
		}
		for(int i = (n-1)/2;i>=0;i--)
		{
			heapify(i);
		}
	}
		
	public void deleteMin()
	{
		int temp = 0;
		temp = arr[0];
		arr[0] = arr[n-1];
		arr[n-1] = temp;
		n--;
		heapify(0);
	}
	
	public void print()
	{
		for(int i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
class main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the size of the heap");
		int n = input.nextInt();
		heap h = new heap(n);	
		int arr[] = new int[n];
		System.out.println("Enter all elements one by one");
		for(int i=0;i<n;i++)
		{
			arr[i] = input.nextInt();
		}
		h.makeHeap(arr);
		h.print();
		h.deleteMin();
		h.print();
	}
}
