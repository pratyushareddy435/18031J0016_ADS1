import java.util.ArrayList;
import java.util.Scanner;
class Student
{
	String Student_Name,DOB;
	int S1M,S2M,S3M,Total_M;
	Student(String sn,String Dob,int s1,int s2,int s3,int t)
	{
		this.Student_Name=sn;
		this.DOB=Dob;
		this.S1M=s1;
		this.S2M=s2;
		this.S3M=s3;
		this.Total_M=t;
	}
}

class Pc3 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		ArrayList<Student> arr=new ArrayList<Student>();
		while(sc.hasNext())
		{
			String a=sc.nextLine();
			String[] b=a.split(",");
			Student st=new Student(b[0],b[1],Integer.parseInt(b[2]),Integer.parseInt(b[3]),Integer.parseInt(b[4]),Integer.parseInt(b[5]));
			arr.add(st);
			sort(arr,0,arr.size()-1);
			
		}
		for(int i=0;i<arr.size();i++)
		{
			Student pr=(Student)arr.get(i);
			System.out.println(pr.Student_Name+","+pr.DOB+","+pr.S1M+","+pr.S2M+","+pr.S2M+","+pr.Total_M);
		}
	}
	private static void sort(ArrayList arr,int low,int high) 
	{
		if(low<high)
		{
		 int key = partition(arr, low, high);
	        sort(arr, low, key - 1);
	        sort(arr, key + 1, high);
		}
	}
	private static int partition(ArrayList arr, int low, int high)
	{

		 int i = low;
	     int j = high + 1;
	     Student v = (Student) arr.get(low);
	     while (true) { 
	    	 
	    	 i++;
	         while ((i<=high && LesscompareTo((Student)arr.get(i),v))) {
	        	 i++;
	             if (i == high) break;
	         }
	         j--;
	         while (HighcompareTo((Student)arr.get(j),v)) {
	        	 j--;
	             if (j == low) break;  
	         }
	         if (i >= j) break;

	         swap(arr,i,j);
		
	     }
	     swap(arr,low,j);
	     return j;
	}
	
	private static boolean HighcompareTo(Student s, Student v) {
		if(s.Total_M==v.Total_M)
		{
			if(s.S2M==v.S2M)
			{
				if(s.S2M==v.S2M)
				{
					if(s.S1M==v.S1M)
					{
						if(compareToDob(s.DOB,v.DOB)>0)
						{
							return false;
						}
						return true;
					}
					else if(s.S1M>v.S1M)
					{
						return false;
					}
					else
					{
						return true;
					}
				}
				else if(s.S2M>v.S2M)
				{
					return false;
				}
				else
				{
					return true;
				}
			}
			else if(s.S2M>v.S2M)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else if(s.Total_M>v.Total_M)
		{
			return false;
		}
		else
		{
			return true;
		}
		
		
	}
	private static boolean LesscompareTo(Student s, Student v) {
		if(s.Total_M==v.Total_M)
		{
			if(s.S2M==v.S2M)
			{
				if(s.S2M==v.S2M)
				{
					if(s.S1M==v.S1M)
					{
						if(compareToDob(s.DOB,v.DOB)<0)
						{
							return true;
						}
						return false;
					}
					else if(s.S1M>v.S1M)
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				else if(s.S2M>v.S2M)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else if(s.S2M>v.S2M)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(s.Total_M>v.Total_M)
		{
			return true;
		}
		else
		{
			return false;
		}
		

	}
	private static int compareToDob(String dOB, String dOB2) {
		String[] a=dOB.split("-");
		String[] b=dOB2.split("-");
		if(Integer.parseInt(a[2])==Integer.parseInt(b[2]))
		{
			if(Integer.parseInt(a[1])==Integer.parseInt(b[1]))
			{
				if(Integer.parseInt(a[0])>Integer.parseInt(b[0]))
					return 1;
				else
					return -1;
			}
			if(Integer.parseInt(a[1])>Integer.parseInt(b[1]))
				return 1;
			else
				return -1;
		}
		if(Integer.parseInt(a[2])>Integer.parseInt(b[2]))
			return 1;
		else
			return -1;		
	}
	
	private static void swap(ArrayList arr, int i, int j) 
	{
		Student temp=(Student) arr.get(i);
		arr.set(i, (Student)arr.get(j));
		arr.set(j, temp);
	}
}

