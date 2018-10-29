import java.util.*;

public class Solution {
	public static void main(String[] args)
	{	
		Scanner sc=new Scanner(System.in);
		String n=sc.nextLine();
		while(sc.hasNext())
		{
			cutoff=Integer.parseInt(sc.nextLine());
			String s=sc.nextLine();
			String []b=s.split(" ");
			quickSort2(b,0,b.length-1,cutoff);
		}	
	}	
	static int pi,cutoff;
	
	 static  void quickSort2 (String[] arr,int l,int h,int cutoff)
	{
		 //System.out.println(Arrays.toString(arr));
		 if((h-l)<cutoff)
		 {		 
			 int i, j;
		     String key;
		
		  if(h-l>=-1)
			System.out.println("insertionSort called");
			   for (i = l+1; i<=h; i++) 
			   { 
			       key = arr[i]; 
			       j = i-1;
			       while (j >= 0&&arr[j].compareTo(key)>0)
			       { 
			           arr[j+1] = arr[j];
			    	   j = j-1; 
			       } 
			     arr[j+1] = key; 
			   }
		 }
		else
		if(l>=0 && h<=arr.length)
		{
			
	    if (l < h)
	    {
	    	if(h-l>=cutoff)
	    	{
	         pi = partition(arr, l, h);
	        System.out.println(Arrays.toString(arr));
                    if(pi>0&&pi<=arr.length)
	        quickSort2(arr, l, pi - 1,cutoff);  // Before pi
                    if(h>=0 && h<=arr.length)
	        quickSort2(arr, pi + 1, h,cutoff); // After pi
	    	}
	    }
		}
	}
	 private static int partition(String[] a, int lo, int hi) {
		 int i = lo;
	     int j = hi + 1;
	     String v = a[lo];
	     while (true) { 
	    	 
	    	 i++;
	    	// System.out.print("i val:"+i );
	         while ((i<=hi && a[i].compareTo(v)<0)) {
	        	 i++;
	             if (i == hi) break;
	         }
	         j--;
	         //System.out.println("j val:"+j );

	         while (a[j].compareTo(v)>0) {
	        	 j--;
	             if (j == lo) break;  
	         }
	         if (i >= j) break;

		String temp = a[i]; 
	    a[i] =a[j]; 
	    a[j] = temp;
	     }
	     //System.out.println("io ..i val:"+i);
	     String temp = a[lo]; 
	     a[lo] = a[j]; 
	     a[j] = temp;
	     return j;
	    }
}
