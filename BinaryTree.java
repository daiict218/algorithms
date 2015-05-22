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

	public void setLeft(node n)
	{
		this.left = n;
	}

	public node getLeft()
	{
		return left;
	}

	public void setRight(node n)
	{
		this.right = n;
	}

	public node getRight()
	{
		return right;
	}
}

class tree
{
	node root;
	
	public tree()
	{
		this.root = null;
	}

	public void insert()
	{
		node x = new node(4);
		node y = new node(5);
		node z = new node(6);
                x.setLeft(y);
                x.setRight(z);
		y = new node(7);
		z = new node(8);
                x.getLeft().setLeft(y);
                x.getLeft().setRight(z);
		y = new node(9);
		z = new node(10);
                x.getRight().setLeft(y);
                x.getRight().setRight(z);

		inOrder(x);
		preOrder(x);
		postOrder(x);
	}

	public void inOrder(node n)
	{
		if(n != null)
		{
			inOrder(n.getLeft());
			System.out.println(n.getData());
			inOrder(n.getRight());
		}
	}

	public void preOrder(node n)
	{
		if(n != null)
		{
			System.out.println(n.getData());
			preOrder(n.getLeft());
			preOrder(n.getRight());
		}
	}

	public void postOrder(node n)
	{
		if(n != null)
		{
			postOrder(n.getLeft());
			postOrder(n.getRight());			
			System.out.println(n.getData());
		}		
	}
}
class main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		tree t = new tree();
		t.insert();
//		t.inOrder();
//		t.preOrder();
//		t.postOrder();
	}
}
