import java.util.Random;
import java.util.Scanner;
public class ME
{
    static int max=30000;
    public static void main(String[] args)
    {
        int a[]=new int[max];
        long start,end;
        Scanner sobj=new Scanner (System.in);
        System.out.println("********SELECTION SORT ALGORITHM********");
        System.out.println("Enter the no. of elements to be sorted :");
        int n=sobj.nextInt();
        Random rand=new Random();
        for(int i=0;i<n;i++)
        {
            a[i]=rand.nextInt(100);
        }
        System.out.println("Array elements to be sorted are :");
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
        start=System.nanoTime();
        selectionSort(a,n);
        end=System.nanoTime();
        System.out.println("\nThe sorted elements are :");
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println("\nThe time taken to sort is "+(end-start)+"ns");
        System.out.println("******************************************");
    }//end of main
    // Selection Sort function
    public static void selectionSort(int a[], int n)
    {
        for( int i = 0; i < n - 1; i++ )
        {
            int minIndex = i;
            for( int j = i + 1; j < n; j++)
            {
                if ( a[j] < a[minIndex] )
                    minIndex = j;
            }
            swap(a, i, minIndex);
        }
    }
    public static void swap(int a[], int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}













