import java.util.Scanner;
class node
{
	int data;
	node left;
	node right;
		
	public node(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	public int getData()
	{
		return data;
	}
	
	public void setRight(node n)
	{
		this.right = n;
	}

	public node getRight()
	{
		return right;
	}

	public void setLeft(node n)
	{
		this.left = n;
	}

	public node getLeft()
	{
		return left;
	}
}

class bst
{
	public node root;
		
	public bst()
	{
		this.root = null;
	}	

	
	public void insert(int data)
	{
		node n = new node(data);
		insertA(root,n);
	}

	public void insertA(node a, node n)
	{
		if(root == null)
		{
			root = n;
		}
		else
		{
			if(n.getData() > a.getData())
			{
				if(a.getRight() == null)
				{
					a.setRight(n);
				}
				else
				{
					insertA(a.getRight(),n);
				}
			}
			else
			{
				if(a.getLeft() == null)
				{
					a.setLeft(n);	
				}
				else
				{
					insertA(a.getLeft(),n);
				}
			}
		}
	}

	public node Search(node a,int data)
	{
		if(root == null)
		{
			return null;
		}
		if(a == null)
		{
			return null;
		}
		else
		{
			if(a.getData() == data)
			{
				return a;
			}
			else
			{
				if(data > a.getData())
				{
					return Search(a.getRight(),data);
				}
				else
				{
					return Search(a.getLeft(),data);
				}
			}
		}
	}

	public void inOrder(node r)
	{
		if(r!=null)
		{
			inOrder(r.getLeft());
			System.out.print(r.getData()+" ");
			inOrder(r.getRight());
		}
	}
}

class main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter total number of nodes in binary search tree");
		int n = input.nextInt();
		bst b = new bst();
		System.out.println("Enter data one by one");
		for(int i=0;i<n;i++)
		{
			b.insert(input.nextInt());
		}
		System.out.println("Inorder traversal");
		b.inOrder(b.root);
		System.out.println();
		System.out.println("Enter the data to be Searched");	
		int data = input.nextInt();
		if(b.Search(b.root,data) != null)
		{
			System.out.println("Data found");
		}
		else
		{
			System.out.println("Data not found");
		}
	}
}
