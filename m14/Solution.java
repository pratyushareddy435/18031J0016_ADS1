import java.util.Scanner;


public class Solution 

{ 
   
 public static void sort(double arr[],int l) 
 
   { 
        
int n =l; 
 
        
for (int i = n/2 - 1  ; i >= 0; i--) 
           
 heapify(arr, n, i);
       
 for (int i=n-1; i>=0; i--) 
       
 { 
            
double temp = arr[0]; 
            
arr[0] = arr[i]; 
           
 arr[i] = temp;
           
 heapify(arr, i, 0); 
      
  } 
   
 } 
 
    
static void heapify(double[] arr, int n, int i) 
   
 { 
        
int largest = i; 
        
int l = 2*i + 1; 
       
 int r = 2*i + 2;
        
if (l < n && arr[l] > arr[largest]) 
            
largest = l;
       
 if (r < n && arr[r] > arr[largest]) 
            
largest = r; 
       
 if (largest != i) 
       
 { 
           
 double swap = arr[i]; 
            
arr[i] = arr[largest]; 
           
 arr[largest] = swap;
            
heapify(arr, n, largest); 
      
  } 
    
} 
    
static void printArray(double arr[],int l) 
   
 { 
        
int n = l; 
      
 //for (int i=0; i<l; ++i) 
      
 //     System.out.print(arr[i]+" "); 
     
  // System.out.println();
      
  if(n==1)
        
{
        	
System.out.println(arr[0]);
      
  }
       
 else if(n%2!=0)
        
{
        	
int n1=n/2;
        	
System.out.println(arr[n1]);
       
 }
       
 else if(n%2==0) 
       
 {
        	
int n2=(n/2)-1;
        	
int n3=n/2;
        	
double x=(arr[n2]+arr[n3])/2;
        
	System.out.println(x);
       
 }
   
 } 

	
public static void main(String[] args)
 {  
	
Scanner sc= new Scanner(System.in);
	
int num = sc.nextInt();

double a[]=new double[num];
	
//a=null;
	
int l=0;
	
for(int i=0;i<num;i++)
	
{
		
l=i+1;
		
a[i]=sc.nextInt();
		
sort(a,l);
		
printArray(a,l);
	
}
	
}

}
