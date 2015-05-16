import java.util.Scanner;
class node
{
	int data;
	node next;
	
	public node(int data)
	{
		this.data = data;
		this.next = null;
	}

	public void setData(int data)
	{
		this.data = data;
	}
	
	public int getData()
	{
		return this.data;
	}

	public void setNext(node n)
	{
		this.next = n;
	}
	
	public node getNext()
	{
		return this.next;
	}
}

class linkedlist
{
	node head;
	
	public linkedlist()	
	{
		this.head = null;
	}
}

class main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		
	}
}
