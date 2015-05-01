import java.util.Scanner;
class main
{
	public static void main(String args[])
	{		
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int arr[] = new int[n];
		for(int i = 0;i<n;i++)
		{
			arr[i] = input.nextInt();
		}
		int M[] = new int[n];
		int sum = 0;
		if(arr[0]<0)
		{
			M[0] = 0;
		}
		else
		{
			M[0] = arr[0];
		}
		int max = Integer.MIN_VALUE;
		for(int i = 1;i<n;i++)
		{
			M[i] = Math.max(M[i-1]+arr[i],0);
			if(M[i]>max)
			{
				max = M[i];
			}
		}
		System.out.println(max);
	}
}
