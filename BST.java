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

	public node SearchParent(node a,int data)
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
			node r = root;
			node prev = null;
			while(r != null)
			{
				if(r.getRight() != null)
				{
					if(r.getRight().getData() == data)	
					{
						return r;
					}
				}
				if(r.getLeft() != null)
				{
					if(r.getLeft().getData() == data)
					{
						return r;
					}
				}
				if(r.getData() > data)
				{	
					prev = r;
					r = r.getLeft();
				}
				else if(r.getData() < data)
				{
					prev = r;
					r = r.getRight();
				}
				else
				{
					break;
				}
			}
			return prev;
		}
        }

	public int minimum(node n)
	{
		if(n!=null)
		{
			if(n.getLeft() == null)
			{
				return n.getData();
			}
			else
			{
				return minimum(n.getLeft());
			}
		}
		return -1;
	}	

	public int maximum(node n)
	{
		if(n!=null)
		{
			if(n.getRight() == null)
			{
				return n.getData();
			}
			else
			{
				return maximum(n.getRight());
			}
		}
		return -1;
	}

	public node Successor(int data)
	{
		node x = Search(root,data);
		if(x.getRight()!=null)
		{
			int l = minimum(x.getRight());
			node p = Search(root,l);
			return p;
		}
		else
		{
			node succ = null;
			node r = root;
			while(r!=null)
			{
				if(r.getData() > x.getData())
				{
					succ = r;
					r = r.getLeft();
				}
				else if(r.getData() < x.getData())
				{
					r = r.getRight();
				}
				else
				{
					break;
				}
			}
			return succ;
		}
	}	
	
	public node Predecessor(int data)
	{
		node x = Search(root,data);
		if(x.getLeft() != null)
		{
			int l = maximum(x.getLeft());
			node p = Search(root,l);
			return p;
		}
		else
		{
			node pre = null;
			node r = root;
			while(r!=null)
			{
				if(r.getData() < x.getData())
				{
					pre = r;
					r = r.getRight();
				}
				else if(r.getData() > x.getData())
				{
					r = r.getLeft();
				}
				else
				{
					break;
				}
			}
			return pre;
		}
	}

	public void delete(int data)
	{
		node x = Search(root,data);
		if(x.getLeft() == null && x.getRight()== null)
		{
			node p = SearchParent(root,data);
			if(p == null)
			{
				root = null;
			}
			else
			{
				if(p.getRight()!=null)
				{
					if(p.getRight().getData() == data)
					{
						p.setRight(null);
					}
				}
				if(p.getLeft()!=null)
				{
					if(p.getLeft().getData() == data)
					{
						p.setLeft(null);
					}
				}
			}
		}
		if(x.getLeft() == null && x.getRight() != null)
		{
			node p = SearchParent(root,data);
			if(p == null)
			{
				root = x.getRight();
				x.setRight(null);
			}
			else
			{
				if(p.getRight() == x)
				{
					p.setRight(x.getRight());
					x.setRight(null);
				}
				if(p.getLeft() == x)
				{
					p.setLeft(x.getRight());
					x.setRight(null);
				}
			}
		}
		if(x.getLeft() != null && x.getRight() == null)
		{
			node p = SearchParent(root,data);
                        if(p == null)
                        {
                                root = x.getLeft();
                                x.setLeft(null);
                        }
                        else
                        {
                                if(p.getRight() == x)
                                {
                                        p.setRight(x.getLeft());
                                        x.setLeft(null);
                                }
                                if(p.getLeft() == x)
                                {
                                        p.setLeft(x.getLeft());
                                        x.setLeft(null);
                                }
                        }
		}
		if(x.getLeft() != null && x.getRight() != null)
		{
			node y = Successor(x.getData());
			int temp = 0;
			temp = y.getData();
			y.setData(x.getData());
			x.setData(temp);
			if(y.getLeft() == null && y.getRight()== null)
			{
				node p = SearchParent(root,data);
				if(p == null)
				{
					root = null;
				}
				else
				{
					if(p.getRight()!=null)
					{
						if(p.getRight().getData() == data)
						{
							p.setRight(null);
						}
					}
					if(p.getLeft()!=null)
					{
						if(p.getLeft().getData() == data)
						{
							p.setLeft(null);
						}
					}
				}
			}
			if(y.getLeft() == null && y.getRight() != null)
			{
				node p = SearchParent(root,data);
				if(p == null)
				{
					root = y.getRight();
					y.setRight(null);
				}
				else
				{
					if(p.getRight() == y)
					{
						p.setRight(y.getRight());
						y.setRight(null);
					}
					if(p.getLeft() == y)
					{
						p.setLeft(y.getRight());
						y.setRight(null);
					}
				}
			}
			if(y.getLeft() != null && y.getRight() == null)
			{
				node p = SearchParent(root,data);
		                if(p == null)
		                {
		                        root = y.getLeft();
		                        y.setLeft(null);
		                }
		                else
		                {
		                        if(p.getRight() == y)
		                        {
		                                p.setRight(y.getLeft());
		                                y.setLeft(null);
		                        }
		                        if(p.getLeft() == y)
		                        {
		                                p.setLeft(y.getLeft());
		                                y.setLeft(null);
		                        }
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
		System.out.println(b.minimum(b.root));
		System.out.println(b.maximum(b.root));
		System.out.println("Enter the element whose successor you want to find out");
		int l = input.nextInt();
		System.out.println(b.SearchParent(b.root,l).getData());
		if(b.Successor(l)!=null)
		{
			System.out.println(b.Successor(l).getData());
		}
		else
		{
			System.out.println("Successor not found");
		}
		if(b.Predecessor(l)!=null)
		{
			System.out.println(b.Predecessor(l).getData());
		}
		else
		{
			System.out.println("Predecessor not found");
		}
		System.out.println("Enter the node you want to delete");
		b.delete(input.nextInt());
		b.inOrder(b.root);
		System.out.println();
	}
}
