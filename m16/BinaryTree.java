
import java.util.Scanner;



class Book{
	String Name;
	String author;
	double price;
	public Book(String name, String author, double price) {
		Name = name;
		this.author = author;
		this.price = price;
	}
	
}

class Node
{
	public Book key;
	public int value;
	public Node left,right;
	public Node(Book key,int value)
	{
		this.key=key;
		this.value=value;
	}
}

public class BinaryTree {
	Node root;
	public void put(Book key,int val) {
		root=put(root,key,val);
	}
	public Node put(Node node,Book key,int val) {
		if(node==null) {
			return new Node(key,val);
		}
		int cmp=key.Name.compareTo(node.key.Name);
		if(cmp<0) {
			node.left=put(node.left,key,val);
		}
		else if(cmp>0) {
			node.right=put(node.right,key,val);
		}
		else {
			node.value=val;
		}
		return node;
	}
	public void print(Node temp) {
		if(temp!=null) {
			print(temp.left);
			System.out.println(temp.key+" "+temp.value);
			print(temp.right);
		}
		
	}
	public int get(Book Key)
	{
		Node node=root;
		while(node!=null)
		{
			if(Key.Name.compareTo(node.key.Name)<0)
				node=node.left;
			else if(Key.Name.compareTo(node.key.Name)>0)
				node=node.right;
			else
				return node.value;
			
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner svn=new Scanner(System.in);
		BinaryTree bt=new BinaryTree();
		while(svn.hasNext()) {
			String s1=svn.nextLine();
			String s2[]=s1.split(",");
			Book b=new Book(s2[1],s2[2],Double.parseDouble(s2[3]));
			switch (s2[0]) {
			case "put":
				bt.put(b, Integer.parseInt(s2[4]));
				break;
			case "get":
				if(bt.get(b)!=0)
					System.out.println(bt.get(b));
				else
					System.out.println("null");
			}
			//System.out.println(bt.print());
		}
		
	}

}
