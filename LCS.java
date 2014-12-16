import java.util.Scanner;
class main
{	
	public static int matrix[][];
        public static char solution[][];
	public static int m,n;
	public static char[] arr;
	public static char[] brr;
	public static char[] y;
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		String X = input.nextLine();
		String Y = input.nextLine();
		m = Y.length();
		n = X.length();
		arr = new char[m+1];
		brr = new char[n+1];
		matrix = new int[m+1][n+1];
		solution = new char[m+1][n+1];
		System.out.println("m: "+m+" n: "+n);
		for(int i=1;i<=m;i++)
                {
                        solution[i][0] = 'x';
                }
		for(int i=0;i<=n;i++)
                {
                        solution[0][i] = 'x';
                }
		for(int i=1;i<=m;i++)
		{
			arr[i] = Y.charAt(i-1);
		}
		for(int i=1;i<=n;i++)
		{
			brr[i] = X.charAt(i-1);
		}
		for(int i = 1;i<=m;i++)
		{
			char a = arr[i];
			for(int j = 1;j<=n;j++)
			{
				char b = brr[j];
				if(a!=b)
				{
					if(matrix[i-1][j] > matrix[i][j-1])
					{
						matrix[i][j] = matrix[i-1][j];
						solution[i][j] = '|';
					}
					else
					{
						matrix[i][j] = matrix[i][j-1];
						solution[i][j] = '-';
					}
				}
				else if(a == b)
				{
					matrix[i][j] = matrix[i-1][j-1]+1;
					solution[i][j] = '\\';
				}
			}
		}
		System.out.println(matrix[m][n]);
		LCSPRINT();
	}

	public static void LCSPRINT()
	{
		int k = matrix[m][n]-1;
		y = new char[matrix[m][n]];
		for(int i = 0;i<m+1;i++)
                {
                        for(int j=0;j<n+1;j++)
                        {
                                System.out.print(matrix[i][j]);
                        }
                        System.out.println();
                }
		for(int i = 0;i<m+1;i++)
		{
			for(int j=0;j<n+1;j++)
			{
				System.out.print(solution[i][j]);
			}
			System.out.println();
		}
		/*for(int i = m;i>0;i--)
		{
			for(int j = n; j>0 ; j--)
			{
				if(solution[i][j] == '\\')
				{
					if(i<0 || k<0)
					{
						break;
					}
					System.out.println(i);
					y[k] = arr[i];
//					y[k] = brr[j];
					i--;
					j--;
					k--;
				}
				else if(solution[i][j] == '|')
				{
					i--;
				}
				else if(solution[i][j] == '-')
				{
					j--;
				}
			}
		}*/
		int l = m+n;
		int i = m;
		int j = n;
		for(l=m+n;l>=0;l--)
		{
			if(solution[i][j]=='\\')
			{
//				System.out.println("hello");
				y[k] = arr[i];
				i--;
				j--;
				k--;
			}
			else if(solution[i][j] == '|')
			{
				i--;
			}
			else if(solution[i][j] == '-')
			{
				j--;
			}
			else
				break;
		}
		for(i=0;i<matrix[m][n];i++)
		{
			System.out.print(y[i]);
		}
		System.out.println();
	}
}
