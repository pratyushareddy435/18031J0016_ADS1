import java.util.Scanner;

public class student {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter number of students");
		int n=sc.nextInt();
		String name[]=new String[n];
		int s1[]=new int[n];
		int s2[]=new int[n];
		int s3[]=new int[n];
		int total[]=new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("enter name");
			name[i]=sc.next();
			System.out.println("enter sub 1 marks");
			s1[i]=sc.nextInt();
			System.out.println("enter sub 2 marks");
			s2[i]=sc.nextInt();
			System.out.println("enter sub 3 marks");
			s3[i]=sc.nextInt();
			System.out.println("enter the total marks");
			total[i]=sc.nextInt();
		}
		for(int j=0;j<total.length;j++)
		{
			int min=j;
			for(int k=min+1;k<total.length;k++)
			{
				if(total[min]>total[k])
				{
					min=k;
				}
				if(total[min]==total[k])
				{
					if(s3[min]>s3[k])
					{
						min=k;
					}
				}
				if(total[min]==total[k]&&s3[min]==s3[k])
				{
					if(s2[min]>s2[k])
							{
								min=k;
							}
				}
				if(total[min]==total[k]&&s3[min]==s3[k]&&s2[min]==s2[k])
				{
					if(s1[min]>s1[k])
					{
						min=k;
					}
				}
				int temp=total[min];
				total[min]=total[k];
				total[k]=temp;
				int t=s3[min];
				s3[min]=s3[k];
				s3[k]=t;
				int t1=s2[min];
				s2[min]=s2[k];
				s2[k]=t1;
				int t2=s1[min];
				s1[min]=s1[k];
				s1[k]=t2;
				String t3=name[min];
				name[min]=name[k];
				name[k]=t3;
			}
		}
		for(int k=0;k<total.length;k++)
		{
			System.out.println("name"+name[k]);
			System.out.println(s1[k]);
			System.out.println(s2[k]);
			System.out.println(s3[k]);
			System.out.println(total[k]);
		}
		
	}
}

