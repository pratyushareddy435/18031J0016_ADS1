package practise;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class AddLargeNumbers 
{ 
	static LinkedList<Integer> obj =new  LinkedList<>();
@SuppressWarnings({ "rawtypes", "unused" })
public static LinkedList numberToDigits(String n1) 
{
	long n2=Integer.parseInt(n1);
	for(int i=0;i<n1.length();i++)
	 {
		 int s=(int) (n2%10);
		 obj.add(s);
		 n2=n2/10;
	 }
	return obj; 
}
@SuppressWarnings("rawtypes")
public static String digitsToNumber(LinkedList obj) 
{
	String str[] = null;
	 @SuppressWarnings("unchecked")
	Iterator<Integer> itr=obj.iterator();
	 for(int i=0;i<obj.size();i++)
	 {
	str[i]=Integer.toString(obj.get(i));
	 }
	return str;

    
}
public static LinkedList addLargeNumbers(LinkedList obj1, LinkedList obj2) 
{
	Stack<Integer> s1=new Stack<>();
	Stack<Integer> s2=new Stack<>();
	LinkedList<Integer> s3=new LinkedList<>();
	for(int i=0;i<obj1.size();i++)
	{
		s1.push(obj.get(i));
	}
	for(int i=0;i<obj2.size();i++)
	{
		s2.push(obj.get(i));
	}
	while(s1.isEmpty()||s2.isEmpty())
	{
		while(s1.pop()+s2.pop()<10)
		{
		s3.add(s1.pop()+s2.pop());
		}
		
			int l=s1.pop()+s2.pop();
			s3.add(l%10);
			l=l/10;
			s3.add(s1.pop()+s2.pop()+(l%10));
			}
	return s3; 
 }
}

public class Solution {

	public static void main(String[] args)
	{
		 Scanner sc = new Scanner(System.in);
	        
		 String input = sc.nextLine();
		        
		  String p = sc.nextLine();
		         
		 String q = sc.nextLine();
		        
		 switch(input){
		            
		  case "numberToDigits":
		                 
		 LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
		                
		  LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
		                
		  System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
		                
		 System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
		                
		  break;

		           
		   case "addLargeNumbers":
		                
		  LinkedList pDigits1 = AddLargeNumbers.numberToDigits(p);
		                
		  LinkedList qDigits1 = AddLargeNumbers.numberToDigits(q);
		                 
		 LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
		                
		  System.out.println(AddLargeNumbers.digitsToNumber(result));
		                
		  break;
		        
		  }
		     

	}

}
