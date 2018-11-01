import java.util.NoSuchElementException;
import java.util.Scanner;



public class Test1<Key extends Comparable<Key>, Value>
{
 private Node root = null;
 
 private class Node
 {
 private Key key;
 private Value val;
 private Node left;
 private Node right;
 
 public Node(Key key2, Value val2)
 {
		
	 this.key=key2;
	 this.val=val2;
	}
 }
 
 public boolean isEmpty()
 { 
 return root == null; 
 }
 
 public void put(Key key, Value value)
 { 
 root = put(root, key, value); 
 }
 private Node put(Node x, Key key, Value val)
 {
  if (x == null) 
	  return new Node(key, val);
  int cmp = key.compareTo(x.key);
  if (cmp < 0) x.left = put(x.left, key, val);
  else if (cmp > 0) x.right = put(x.right, key, val);
  else x.val = val;
  return x;
 }
 public Value get(Key key)
 { 

 return get(root, key);
 }
 
 public boolean contains(Key key)
 { 
   return get(key) != null; 
 }
 private Value get(Node x, Key key)
 {
  if (x == null) 
	  return null;
  int cmp = key.compareTo(x.key);
  if (cmp < 0) 
	  return get(x.left, key);
  else if (cmp > 0) 
	  return get(x.right, key);
  else if (cmp == 0) 
	  return x.val;
return null;
 }
 public Iterable<Key> keys()
 { 
 Queue<Key> q = new Queue<Key>();
 inorder(root, q);
 return q;
 
 }
 private void inorder(Node x, Queue<Key> queue)
 {
  if (x == null) return;
  inorder(x.left, queue);
  queue.enqueue(x.key);
  inorder(x.right, queue);
 }
 public Key max() {
     if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
     return max(root).key;
 } 
 private Node max(Node x) {
     if (x.right == null) return x; 
     else                 return max(x.right); 
 } 

 public static void main(String[] args)
 {
  Test1<String, Integer> st = new Test1<String, Integer>();
  
  Scanner sc=new Scanner(System.in);
   int n=Integer.parseInt(sc.nextLine());
  
  for(int i=0;i<n;i++) {
	  String s=sc.nextLine();
	 String temp[]=s.split(" ");
	 String key=temp[0];
	 int val=Integer.parseInt(temp[1]);
	 st.put(key, val);
	
  }
  for (String s : st.keys())
  {
	  System.out.println("Key : "+s+" Value : "+st.get(s));
  }
  System.out.println("max"+st.max());
  System.out.println(st.contains("A"));
 }
}
