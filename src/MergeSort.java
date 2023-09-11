import java.util.Random;
import java.util.Scanner;
public class MergeSort
{
    static int max=30000;
    public static void main(String[] args)
    {
        int a[]=new int[max];
        long start,end;
        Scanner sobj=new Scanner (System.in);
        System.out.println("********MERGE SORT ALGORITHM********");
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
        mergesort(a,0,n-1);
        end=System.nanoTime();
        System.out.println("\nThe sorted elements are :");
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println("\nThe time taken to sort is "+(end-start)+"ns");
        System.out.println("******************************************");
    }//end of main
    static void mergesort(int a[],int low,int high)
    {
        int mid;
        if(low<high)
        {
            mid=(low+high)/2;
            mergesort(a,low,mid);//recursively sort left part
            mergesort(a,mid+1,high);//recursively sort right part
            merge(a,low,mid,high); // merge two sorted parts
        }
    }
    static void merge(int a[],int low,int mid,int high)
    {
        int i,j,h,k;
        int b[]=new int[max];
        h=low;//h points to first element in first half a[low:mid]
        i=low;
        j=mid+1;//j points to first element in second half a[mid+1:high]
        while((h<=mid)&&(j<=high))
        {
            if(a[h]<a[j])
            {
                b[i]=a[h];
                h=h+1;
            }
            else
            {
                b[i]=a[j];
                j=j+1;
            }
            i=i+1;
        }
        if(h>mid)
        {
            for(k=j;k<=high;k++)
            {
                b[i]=a[k];
                i=i+1;
            }
        }
        else
        {
            for(k=h;k<=mid;k++)
            {
                b[i]=a[k];
                i=i+1;
            }
        }
        for(k=low;k<=high;k++)
            a[k]=b[k];
    }//end of merge
}//end of class merge