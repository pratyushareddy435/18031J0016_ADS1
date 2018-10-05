package module4;

import java.util.Scanner;
import java.util.Stack;

class Postfix
{
	String s;
     int i;
	Postfix(String exp)
	{
		this.s=exp;
	}
	void evaluate(String exp)
	{
		String str[]=exp.split(" ");
		int l=str.length;
		Stack<Integer> stack = new Stack<>(); 
		///int st[]=new int[l];
		for(i=0;i<l;i++)
		{
			if(str[i].equals("*"))
			 {
				//i=i-2;
				int val1=Integer.valueOf(str[i-1]);
				int val2=Integer.valueOf(str[i-2]);
				stack.pop();
				stack.pop();
				stack.push(val1*val2);
			}
			else if(str[i].equals("+"))
			{
				//i=i-2;
				int val1=Integer.valueOf(str[i-1]);
				int val2=Integer.valueOf(str[i-2]);
				stack.pop();
				stack.pop();
				stack.push(val1+val2);
			}
			else if(str[i].equals("-"))
			{
				int val1=Integer.valueOf(str[i-1]);
				int val2=Integer.valueOf(str[i-2]);
				stack.pop();
				stack.pop();
				stack.push(val1-val2);
			}
			else if(str[i].equals("/"))
			{
				int val1=Integer.valueOf(str[i-1]);
				int val2=Integer.valueOf(str[i-2]);
				stack.pop();
				stack.pop();
				stack.push(val1/val2);
			}
			else if(str[i].equals("%"))
			{
				int val1=Integer.valueOf(str[i-1]);
				int val2=Integer.valueOf(str[i-2]);
				stack.pop();
				stack.pop();
				stack.push(val1%val2);
			}
			else
			{
				int val1=Integer.valueOf(str[i]);
				stack.push(val1);
			}
			System.out.println(stack.pop());
		}
		}
}
 class Stackdemo
{

	public static void main(String[] args) 
	{
		String exp;
		Scanner s=new Scanner(System.in);
		System.out.println("enter stringfor postfix nottion" );
		exp=s.nextLine();
		Postfix p=new Postfix(exp);
		p.evaluate(exp);
		

	}

}
