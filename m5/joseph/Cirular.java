package module5;

import java.util.LinkedList;
import java.util.Scanner;

public class Cirular {

	public static void main(String[] args) 
	{
		LinkedList<Integer> ll=new LinkedList<>();
		Scanner sc=new Scanner(System.in);
		int ni=sc.nextInt();
		for(int i=0;i<ni;i++)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			for(int j=0;j<n;j++)
			{
				ll.add(j);
			}
			int temp=0;
			while(ll.size()!=0)
			{
				temp=(temp+m-1)%ll.size();
				System.out.print(ll.get(temp));
				ll.remove(temp);
				
			}
		}

	}

}
