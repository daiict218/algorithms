import java.util.Scanner;
class main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the total number of items present: ");
		int n = input.nextInt();
		int W[] = new int[n+1];
		int B[] = new int[n+1];
		System.out.println("Enter the capacity of the knapsack");
		int C = input.nextInt();
		System.out.println("Enter weight and corresponding value of each item");
		for(int i=1;i<n+1;i++)
		{
			W[i] = input.nextInt();
			B[i] = input.nextInt();
		}
		int M[][] = new int[n+1][C+1];
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<C+1;j++)
			{
				if((j-W[i]) < 0)
				{
					M[i][j] = 0;
				}	
				else
				{
					M[i][j] = Math.max(M[i-1][j],B[i]+M[i-1][j-W[i]]);
				}
			}
		}
		/*for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<C+1;j++)
				System.out.print(M[i][j]);
			System.out.println();
		}*/
		System.out.println(M[n][C]);
	}
}
