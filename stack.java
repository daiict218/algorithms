import java.util.Scanner;
class stack
{
	int top;
	int arr[];
	
	public stack(int n)
	{
		arr = new int[n];
		this.top = -1;
	}

	public void push(int data)
	{
		if(top == arr.length)
		{
			System.out.println("Stack Full");
		}
		else
		{
			top++;
			arr[top] = data;
		}
	}

	public int peek()
	{
		return arr[top];
	}

	public int pop()
	{
		int x = -1;
		if(top >= 0)
		{
			x = arr[top];
			top--;
		}
		else
		{
			System.out.println("Stack Empty");
		}
		return x;
	}
}
class main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		stack s = new stack(10);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
