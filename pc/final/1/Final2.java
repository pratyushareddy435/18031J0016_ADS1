

import java.util.Scanner;

class Student
{                  
    String roll;
    String marks;
    String name;
    Student(String r,String m,String n)
    {
    	roll=r;
    	marks=m;
    	name=n;
    }
}
class Node1
{
	public Student key;
	public String name;
	public Node1 left,right;
	public Node1(Student key,String n)
	{
		this.key=key;
		this.name=n;
	}
}
public class Final2
{
	static Node1 root;
	public void put(Student key,String n) {
		root=put(root,key,n);
	}
	public Node1 put(Node1 node,Student key,String n) {
		if(node==null) {
			return new Node1(key,n);
		}
		int cmp=key.roll.compareTo(node.key.roll);
		if(cmp<0) {
			node.left=put(node.left,key,n);
		}
		else if(cmp>0) {
			node.right=put(node.right,key,n);
		}
		else {
			node.name=n;
		}
		return node;
	}
	public String get(double m1,double m2)
	{
		Node1 node=root;
		
		while(node!=null)
		{
			double m=Double.parseDouble(node.key.marks);
			if((m1<=m)&&(m2>=m))
				return node.name;
			else if(m<m1)
				node=node.right;
			else if(m>m2)
				node=node.left;
			else
				return null;
			
		}
		return null;
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Final2 bt=new Final2();
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			String s1=sc.nextLine();
			String s2[]=s1.split(",");
			Student b=new Student(s2[0],(s2[1]),s2[2]);
			bt.put(b,s2[2]);
			
		}
		int m=sc.nextInt();
		for(int i=0;i<m;i++)
		{
			String s1=sc.nextLine();
			String s2[]=s1.split(" ");
		 System.out.println(bt.get(Double.parseDouble(s2[1]),Double.parseDouble(s2[2])));
			 	
		}
	}

}
