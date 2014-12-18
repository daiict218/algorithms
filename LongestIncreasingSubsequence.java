import java.util.Scanner;
class main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int arr[] = new int[n];
		int LIS[] = new int[n];
		for(int i = 0;i<n;i++)
		{
			arr[i] = input.nextInt();
			LIS[i] = 1;
		}
		for(int i=0;i<n;i++)
		{
			int x = 0;
			int max = Integer.MIN_VALUE;
			for(int j=0;j<i;j++)
			{
				if(arr[j] < arr[i])
				{
					x = 1;
					if(max < LIS[j])
						max = LIS[j];

				}
			}
			if(x == 1)
			{
				LIS[i] = 1+max;
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			if(LIS[i]>max)
			{
				max = LIS[i];
			}
		}
		System.out.println(max);
	}
}
