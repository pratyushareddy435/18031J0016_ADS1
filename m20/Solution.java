

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
	@Override
	public String toString() {
		return  Name + ", " + author + ", " + price;
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

public class Solution {
	Node root;
	
	public Solution() {
		this.root = null;
	}

	static int indx=0;
	public void put(Book key,int val) {
		root=put(root,key,val);
	}
	public Node put(Node node,Book key,int val) {
		if(node==null) {
			//System.out.println("T1:"+key);
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
			System.out.println(temp.key.Name+" "+temp.value);
			print(temp.right);
		}
		
	}
	
	
	

	public Node Floor(Node x,Book key) {
		if(x==null)
			return x;
		int c=key.Name.compareTo(x.key.Name);
		if(c==0)
			return x;
		if(c<0) {
			return Floor(x.left,key);
		}
		Node t=Floor(x.right,key);
		if(t!=null) {
			return t;
		}
			return x;
	}
	public Node Ceiling(Node x,Book key) { 
		if(x==null)
			return x;
		int c=key.Name.compareTo(x.key.Name);
		if(c==0)
			return x;
		if(c>0) {
			return Ceiling(x.right,key);
		}
		Node t=Ceiling(x.left,key);
		if(t!=null) {
			return t;
		}
			return x;
	}
	
	public String minValue(Node node) {
		 
        while(node.left!= null) {
            node = node.left;
        }
        return node.key.toString();
    }
	public String maxValue(Node node) {
		 
        while(node.right!= null) {
            node = node.right;
        }
        return node.key.toString();
    }
	public void Select(int k) {
		
		select(root,k);
	}
	
	public void select(Node temp,int sval) {
		if(temp!=null) {
			select(temp.left,sval);
			if(indx==sval) {
				System.out.println(temp.key);
				indx++;
				return;
			}
			indx++;
			select(temp.right,sval);
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
	public void deletemin() {
		root=deletemin(root);
	}
	public Node deletemin(Node x) {
		if(x.left==null) {
			return x.right;
		}else
			x.left=deletemin(x.left);
		return x;
	}
	public void deletemax() {
		root=deletemax(root);
	}
	public Node deletemax(Node x) {
		if(x.right==null) {
			return x.left;
		}else
			x.right=deletemax(x.right);
		return x;
	}

	public void delete(Book key) {
		root = delete(root, key);
	}

	public Node delete(Node x, Book key) {
		if (x == null)
			return null;
		int cmp = key.Name.compareTo(x.key.Name);
		if (cmp < 0)
			x.left = delete(x.left, key);
		else if (cmp > 0)
			x.right = delete(x.right, key);
		else {
			if (x.right == null)
				return x.left;
			if (x.left == null)
				return x.right;
			Node t = x;
			x = deletemin(t.right);
			x.right = deletemin(t.right);
			x.left = t.left;
		}
		return x;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner svn=new Scanner(System.in);
		Solution bt=new Solution();
		while(svn.hasNext()) {
			String s1=svn.nextLine();
			String s2[]=s1.split(",");
			Node temp;
			Book b=null;
			if(s2.length>2)
				b = new Book(s2[1],s2[2],Double.parseDouble(s2[3]));
			switch (s2[0]) {
			case "put":
				bt.put(b, Integer.parseInt(s2[4]));
				break;
			case "get":
				if(bt.get(b)!=0)
					System.out.println(bt.get(b));
				else
				 	System.out.println("null");
				break;
			case "print":
				bt.print(bt.root);
				break;
			case "floor":
				temp = bt.Floor(bt.root,b);
				System.out.println(temp==null?null:temp.key);
				break;
			case "ceiling":
				temp = bt.Ceiling(bt.root,b);
				System.out.println(temp==null?null:temp.key);
				break;
			case "min":
				System.out.println(bt.minValue(bt.root));
				break;
			case "max":
				System.out.println(bt.maxValue(bt.root));
				break;
			case "select":
				bt.Select(Integer.parseInt(s2[1]));
				break;
			case "deleteMin":
				bt.deletemin();
				break;
			case "deleteMax":
				bt.deletemax();
				break;
			case "delete":
				bt.delete(b);
				break;
			}
			
		}
		
	}

}
