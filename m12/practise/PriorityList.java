import java.util.LinkedList;
import java.util.Scanner;

public class PriorityList 
{
	private static boolean compare(String st[])
	{
		int flag=0;
		for(int i=0;i<st.length;i++)
		{
			if(st[i].compareTo(st[i+1])>0)
			{
				flag++;
			}
		}
		if(flag==st.length)
		{
			return true;
		}
		else
		{
			return false;
		}
				//return false;
		
	}
	public static void main(String[] args)
	{
		Scanner scan  = new Scanner(System.in);
		String ch=scan.next();		
		int n=scan.nextInt();
		String st[]=null;
		for(int i=0;i<n;i++)
		{
			String s=scan.nextLine();
			 st=s.split(",");
			int length=st.length;
			System.out.println(compare(st));
		}	
				
	}
	
}
