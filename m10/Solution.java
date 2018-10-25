import java.util.Scanner;

class Node
{
	int data;
	Node next;
	Node(int a)
	{
		this.data=a;
		this.next=null;
	}
}
class list
{
	int size=0;
	Node Head;
	list()
	{
		Head=null;
	}
public void insertAt(int a,int b,int c)
{
	
	Node n=new Node(b);
	int count=c;
	
	if(a>size+1||a<0)
	{
		System.out.println("Can't insert at this position.");
	}
	else
		{if(Head==null)
	{
		Head=n;
	}
	else if(a==0)
	{
		n.next=Head;
		Head=n;
	}
	else
	{	
		Node temp =Head;
	while(count+1!=a)
	{
		temp=temp.next;
		count++;
	}
	
	n.next=temp.next;
	temp.next=n;
	}
		}
	size++;
}
public void insertAta(int a,int b,int c)
{
	
	Node n=new Node(b);
	int count=c;
	
	if(a>size+1||a<0)
	{
		System.out.println("Can't insert at this position.");
	}
	else
		{if(Head==null)
	{
		Head=n;
	}
	else if(a==0)
	{
		n.next=Head;
		Head=n;
		size++;
	}
	else
	{	
		Node t =Head;
		ins(t,a,b,count,n);
	}
		}}
	
	
	
void	ins(Node temp,int a,int b,int count,Node n)
	{
		if(temp!=null && count<a-1)
		{temp=temp.next;
		count++;
		ins(temp,a,b,count,n);
	}
		else
		{
	n.next=temp.next;
	temp.next=n;
	
		
	size++;
		}
}
public int popend()
{
	size--;
	if(Head==null)
	{
		return 0;
	}
	else if(Head.next==null)
	{
		int a=Head.data;
		Head=null;
		return a;
	}
	else
	{
		Node temp=Head;
		while(temp.next.next!=null)
		{
			temp=temp.next;
		}
		int a=temp.next.data;
		temp.next=null;
		return a;
	}

}
public void reverse(int a)
{
	if(Head==null)
	{
		System.out.println("No elements to reverse.");
	}
	else if(Head.next==null)
	{
		
	}
	else
	{
		int i=a;
//		System.out.println(size+" "+i);
//		
//		System.out.println(size+" "+i);
		if(i!=size)
		{
			int b=popend();
			insertAt(i,b,0);
			i++;
			reverse(i);
		}
	}
}
	public String Disp()
{
	Node temp1=Head;
	String s="";
	if(temp1==null)
	{
		return null;
	}
	else
	{
	while(temp1.next!=null)
	{
		System.out.print(temp1.data+", ");
		temp1=temp1.next;
		
	}
	}
	System.out.println(temp1.data);
	return s;
}
}
class Solution
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		list l=new list();
		while(sc.hasNext())
		{
			String s=sc.nextLine();
			String[]b=s.split(" ");
			
			switch(b[0])
			{
			case "insertAt":
				
				l.insertAta(Integer.parseInt(b[1]), Integer.parseInt(b[2]),0);
				if(Integer.parseInt(b[1])>=0&&Integer.parseInt(b[1])<=l.size)
				l.Disp();
				break;
			case "reverse":
				l.reverse(0);
				l.Disp();
				
			}
		}
	}
}