package pc3ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Studentdetails {
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		String[] st=new String[n+1];
		ArrayList<Student>ar=new ArrayList<Student>();
		for(int i = 0;i<n+1;i++)
		{
			st[i]=s.nextLine();
		}
		
		int j=0;
		String str[]=new String[6];
		String strm[]=new String[n*6];
		//Student[] sd =new Student[n];
		for(int i = 1;i<st.length;i++)
		{
			str=st[i].split(",");
			
			Student su=new Student(str[0],str[1],str[2],str[3],str[4],str[5]);
			ar.add(su);

	}
		QuickSort q= new QuickSort();
		q.sort(ar, 0, n-1);
		for(int i = 0;i<ar.size();i++)
		{
			System.out.println(ar.get(i));
		}
			
		
		
	}
}

