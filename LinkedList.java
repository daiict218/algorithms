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
		return data;
	}

	public void setNext(node n)
	{
		this.next = n;
	}
	
	public node getNext()
	{
		return next;
	}
}

class linkedlist
{
	public node head;
	
	public linkedlist()	
	{
		this.head = null;
	}
		
	public node getHead()
	{
		return head;
	}

	public void insertAtHead(int data)
	{
		node nodetoadd = new node(data);
		if(head == null)
		{
			head = nodetoadd;
		}
		else
		{
			nodetoadd.setNext(head);
			head = nodetoadd;
		}
	}

	public void insertAfterNode(node n,int data)
	{
		node nodetoadd = new node(data);
		nodetoadd.setNext(n.getNext());
		n.setNext(nodetoadd);
	}

	public void insertAtEnd(int data)
	{
		node nodetoadd = new node(data);
		if(head == null)
		{
			head = nodetoadd;
		}
		else
		{
			node temp = head;
			while(temp.getNext()!=null)
			{
				temp = temp.getNext();
			}
			temp.setNext(nodetoadd);
		}
	}

	public void print()
	{
		node temp = head;
		while(temp != null)
		{
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
		System.out.println();
	}

	public void delete(int data)
	{
		node temp = head;
		node prev = null;
		
		if(temp == null)
		{
			System.out.println("Linkedlist is empty.");
		}

		if(head.getData() == data && head.getNext() == null)
		{
			head = null;
		}
		else if(head.getData() == data && head.getNext() != null)
		{
			head = temp.getNext();
			temp.setNext(null);
		}
		else
		{
			while(temp.getData() != data)
			{
				prev = temp;
				temp = temp.getNext();
			}
			prev.setNext(temp.getNext());
			temp.setNext(null);
		}
		System.out.println();
	}

	public int length(node n)
	{
		if(n == null)
		{
			return 0;
		}
		return 1 + length(n.getNext());
	}

	public node ReversePair(node n)
	{
		if(n.getNext() == null || n == null)
		{
			return n;
		}
		node temp1 = n.getNext();
		node temp = n.getNext().getNext();
		n.getNext().setNext(n);
	//	System.out.println(temp);
		if(temp != null)
			n.setNext(ReversePair(temp));
		else
			n.setNext(null);
		return temp1;
	}
	
	public node deleteAlternate(node n)
	{
		if(n.getNext() == null)
		{
			return n;
		}
		if(n.getNext().getNext() == null)
		{
			n.setNext(null);
			return n;
		}
		n.setNext(deleteAlternate(n.getNext().getNext()));
		return n;
	}
}

class main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		linkedlist list = new linkedlist();
		list.insertAtEnd(10);
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtHead(4);
		list.insertAtHead(5);
		list.insertAfterNode(list.head,6);
		list.print();
		//System.out.println(list.length(list.head));
		//list.delete(5);
		//list.print();
		//System.out.println(list.length(list.head));
//		list.head = list.ReversePair(list.head);
//		System.out.println(list.head.data);
//		System.out.println(list.head.next.data);
//		System.out.println(list.head.next.next.data);
//		System.out.println(list.head.next.next.next.data);
//		System.out.println(list.head.next.next.next.next.data);
//		System.out.println(list.head.next.next.next.next.next.data);
		list.head = list.deleteAlternate(list.head);
		list.print();
	}
}
