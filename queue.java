import java.util.Scanner;
class queue
{
	int n;
	int head;
	int tail;
	int arr[];	

	public queue(int n)
	{
		this.n = n;
		arr = new int[n];
		this.head = 0;
		this.tail = 0;
	}

	public void enqueue(int data)
	{
		if(head == (tail+1)%n)
		{
			System.out.println("queue full");
		}
		else
		{
			arr[tail] = data;
			tail = (tail + 1)%n;
		}
	}
	
	public int dequeue()
	{
		int x = -1;
		if(head == tail)
		{
			System.out.println("Queue empty");
		}
		else
		{
			x = arr[head];
			head  = (head + 1)%n;
		}
		return x;
	}
}
class main
{
	public static void main(String args[])
	{
		queue q = new queue(4);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		System.out.println(q.dequeue());
                System.out.println(q.dequeue());
                System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
