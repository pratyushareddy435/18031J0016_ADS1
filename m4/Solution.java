

import java.util.Scanner;

public class Solution
{
	
	public static void main (String [] args)
	{
		Scanner sc=new Scanner(System.in);		
		String st=sc.nextLine();
		char co;
		boolean comp=true;
		while(sc.hasNext())
		{
			st=sc.nextLine();
			Stack s= new Stack(st.length());
			for(int i=0;i<st.length();i++)
			{
				char ch=st.charAt(i);
				switch(ch)
				{
					case '{' :
						s.push(ch);
						break;
					case '(' :
						s.push(ch);
						break;
					case '[' :
						s.push(ch);
						break;
					case '}' :
						co=s.pop();
						comp=(co=='{');
						break;
					case ')' :
						co=s.pop();
						comp=(co=='(');
						break;
					case ']' :
						co=s.pop();
						comp=(co=='[');
						
						break;
				}
				if(comp==false)
				{
					break;
				}	
			}
			if(comp==false)
			{
				comp=true;
				System.out.println("NO");
			}
			else
			{
				System.out.println("YES");
			}
		}
	}
}
class Stack
{
	char [] a;
	int Top=0;
	public Stack(int n)
	{
		a= new char [n];
	}
	boolean IsEmpty()
	{
		return Top==0;
	}
	boolean IsFull()
	{
		
		return Top==a.length;
	}
	char pop()
	{
		char b=0;
		if (!IsEmpty()) 
        { 
            b=a[--Top];
            return b;
        }
		return b;
		
	}
	void push(char i)
	{
		if(!IsFull())
		{
			a[Top++]=i;
		}
	}
}
