import java.util.Scanner;
class main
{
        public static void main(String args[])
        {
                Scanner input = new Scanner(System.in);
                int n = input.nextInt();
                int arr[] = new int[n+1];
                for(int i=1;i<n+1;i++)
                {
                        arr[i] = input.nextInt();
                }
                int dynamic[] = new int[n+1];
                for(int i=1;i<n+1;i++)
                {
                        dynamic[i] = 1;
                }
                dynamic[0] = 1;
                int max = Integer.MIN_VALUE;
                for(int i=1;i<n+1;i++)
                {
                        for(int j=1;j<i;j++)
                        {
                                if(arr[i]>arr[j] && dynamic[i]<dynamic[j]+1)
                                {
                                        dynamic[i] = dynamic[j]+1;
                                }
                        }
                }
                for(int i=1;i<n+1;i++)
                {
                        System.out.println("dynamic["+i+"]: "+dynamic[i]);
                }
                for(int i=1;i<n+1;i++)
                {
                        if(dynamic[i]>max)
                        {
                                max = dynamic[i];
                        }
                }
                System.out.println(max);
        }
}

