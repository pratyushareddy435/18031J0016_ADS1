
import java.util.*;
class Studentdata
{                  
    String roll;
    double marks;
    String name;
    Studentdata(String r,String n,double m)
    {
    	roll=r;
    	marks=m;
    	name=n;
    }
    
}
class Hash{

	int hashing(String roll)
	{
		int ind=0;
      for(int i=0;i<roll.length();i++)
        {
    	  ind+=i*roll.charAt(i);

		}
      return ind%2001;
	}
 }
public class Final1
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Studentdata sd[] = new Studentdata[2001];
		Hash h = new Hash();
       for(int i=0;i<n;i++)
       {
    	   String str = sc.next();
    	   String s[] = str.split(",");
    	   sd[h.hashing(s[0])]= new Studentdata(s[0],s[1],Double.parseDouble(s[2]));
 }
      int n2=sc.nextInt();
       //String r=sc.next();
       int c=0;
       for(int i = 0;i<n2;i++)
       {
       	String s1=sc.nextLine();
       	 //c=0;
       	String s2[]=s1.split(" ");
       	for(int j = 0;j<s1.length();j++)
       	{
      	if(s2[1].equals(s2[j]))
       		{
       			c++;
       			break;
       		}
       	}
       	if(c==1)
       	{
       	switch (s2[2])
       	{
       	case "1":{
       		System.out.println(sd[h.hashing(s2[1])].name);
       		break;
             	}
       	case "2":{
       		System.out.println(sd[h.hashing(s2[1])].marks);
       		break;
            	}
       	}
       }
       	else
       	{
       		System.out.println("Student doesn't exists...");
       	}
       }
	}
}
