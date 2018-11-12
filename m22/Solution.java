import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class  Solution<Key, Value> 
{   private int N; // number of key-value pairs in the table   
    private int M = 16;    // size of linear-probing table                   
    private Key[] keys;    // the keys                                         
    private Value[] vals;  // the values      
    
    public Solution()   
    {      keys = (Key[])   new Object[M];      
           vals = (Value[]) new Object[M];   
    }
    public Solution(int m)
    {
    	M = m;
        N = 0;
        keys = (Key[])   new Object[M];
        vals = (Value[]) new Object[M];
    }
    private int hash(Key key)   
    {   
    	String b=key.toString();
    	int k=(int)b.charAt(0);
    	return (11*k)% M;
    }   
    private void resize(int cap)
    {
    	Solution<Key, Value> t;    
    	t = new Solution<Key, Value>(cap);    
    	for (int i = 0; i < M; i++)       
    		if (keys[i] != null)           
    			t.put(keys[i], vals[i]);    
    	keys = t.keys;    
    	vals = t.vals;    
    	M    = t.M;
    }
    public void put(Key key, Value val)   
    {      if (N >= M/2) resize(2*M);  // double M (see text)      
           int i;      
           for (i = hash(key); keys[i] != null; 
        		   i = (i + 1) % M)        
        	   if (keys[i].equals(key)) 
        	   { vals[i] = val; return;
        	   }      
           keys[i] = key;      
           vals[i] = val;       
           N++;   
           }
    public Value get(Key key)   
    {     
    	for (int i = hash(key); keys[i] != null; i = (i + 1) % M)       
    		if (keys[i].equals(key))            
    			return vals[i];     
    	return null;  
    	}
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }

        // delete key and associated value
        keys[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            
            N--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % M;
        }

        N--;

        // halves size of array if it's 12.5% full or less
        if (N > 0 && N <= M/8) 
        	resize(M/2);
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < M; i++)
            if (keys[i] != null) //queue.enqueue(keys[i]);
            	queue.add(keys[i]);
        return queue;
    }
    

	public static void main(String[] args)
	{
		Scanner sc=new Scanner (System.in);
		Solution<String,Integer> ob=new Solution<String,Integer>();
		String n=sc.nextLine();
		while(sc.hasNext())
		{
			String s=sc.nextLine();
			String[] k=s.split(" ");
			switch (k[0])
			{
			case "put":
				       
				       ob.put(k[1],Integer.parseInt(k[2]));
				       break;
			case "get":
				       System.out.println(ob.get(k[1]));
				       break;
			case "delete":
				         ob.delete(k[1]);
				        break;
			case "display":
				// Queue f=ob.keys();
				System.out.print("{");
				int i=0;
				for (String v : ob.keys())
					
					if(i++ == ob.size()-1) {
						System.out.println(v+":"+ob.get(v)+"}");
					}else {
						System.out.print(v+":"+ob.get(v)+", ");
					}
					
				         break;
				        
			}
		}
		
	}
}
	

