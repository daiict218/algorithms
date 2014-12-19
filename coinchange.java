import java.util.Scanner;
class main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the amount of money you want change for: ");
		int money = input.nextInt();
		System.out.println("Enter total number of coins: ");
		int numCoins = input.nextInt();
		System.out.println("Enter value of each coin one by one: ");
		int coins[] = new int[numCoins+1];
		for(int i=1;i<numCoins+1;i++)
		{
			coins[i] = input.nextInt();
		}
		int M[][] = new int[numCoins+1][money+1];
		for(int i=0;i<numCoins+1;i++)
		{
			M[i][0] = 1;
		}
		int l = 0;
		for(int i=1;i<numCoins+1;i++)
		{
			for(int j=1;j<money+1;j++)
			{
				if(j-coins[i]<0)
				{
					M[i][j] = 0;
					l = 0;
				}
				else
				{
					l = M[i][j-coins[i]];		
					//M[i][j] = M[i-1][j]+M[i][j-coins[i]];
				}
				M[i][j] = M[i-1][j]+l;
			}
		}
		System.out.println(M[numCoins][money]);
	}
}
