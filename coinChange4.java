import java.util.Scanner;
class main
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
                System.out.println("Enter the amount of money for which you want the change: ");
                int money = input.nextInt();
                System.out.println("Enter the number of coins: ");
                int numCoins = input.nextInt();
                int coins[] = new int[numCoins+1];
                System.out.println("Enter all the coins one by one: ");
                for(int i=1;i<numCoins+1;i++)
                {
                        coins[i] = input.nextInt();
                }
		int M[] = new int[money+1];
		M[0] = 0;
		for(int i=1;i<money+1;i++)
		{
			M[i] = 100000000;
		}
		for(int i=1;i<money+1;i++)
		{
			int min = 100000000;
			for(int j = 1;j<numCoins+1;j++)
			{
				if(i-coins[j]>=0 && M[i-coins[j]]!=Integer.MAX_VALUE)
				{
					if(min > M[i-coins[j]])
					{
						min = M[i-coins[j]];
					}
//					System.out.println(min);
/*					if(i==10)
					{
						System.out.println(min);
					}*/
				}
			}
			M[i] = min+1;
//			System.out.printf("M[%d] : %d ",i,M[i]);
		}
		System.out.println(M[money]);
	}
}
