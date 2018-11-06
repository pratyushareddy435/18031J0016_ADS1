

import java.util.Scanner;

class KeyVal {
	String key;
	int val;
	public KeyVal(String key, int val) {
		this.key = key;
		this.val = val;
	}
}

public class BstArray {
	KeyVal kv[];
	public BstArray(int size) {
		kv = new KeyVal[size];
	}
	
	public void inorder(int cs) {
		if (kv[cs] != null) {
			inorder(cs * 2 + 1);
			System.out.println(kv[cs].key+" "+kv[cs].val);
			inorder(cs * 2 + 2);
		}
	}
	
	public int contains(String key) {
		int i = 0;
		while (kv[i] != null && kv[i].key.compareTo(key) != 0) 
			i =2 * i + (kv[i].key.compareTo(key) > 0 ? 1 : 2);
		return kv[i] != null ? i : -1;
	}
	
	public String floor(String key) {
		int i=0;
		while (kv[i] != null && kv[i].key.compareTo(key) != 0) 
			i =2 * i + (kv[i].key.compareTo(key) > 0 ? 1 : 2);
		if(kv[i].key.compareTo(key)==0)
			return kv[i].key;
		else if(kv[(i-1)/2].key.compareTo(key)<0)
			return kv[(i-1)/2].key;
		return null;
	}
	
	public int rank(String key) {
		return 0;
	}

	public static void main(String[] args) {
		BstArray ba = new BstArray(100);
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		String sp[] = st.split(" ");
		ba.kv[0] = new KeyVal(sp[0], 0);
		for (int i = 1; i < sp.length; i++) {
			int j = 0, f1 = 0;
			while (ba.kv[j] != null) {
				if (ba.kv[j].key.compareTo(sp[i]) > 0) 
					j = 2 * j + 1;
				else if (ba.kv[j].key.compareTo(sp[i]) < 0) 
					j = 2 * j + 2;
				else {
					ba.kv[j].val = i;
					f1 = 1;
					break;
				}
			}
			if (f1 == 0) 
				ba.kv[j] = new KeyVal(sp[i], i);
		}
		while (sc.hasNext()) {
			st = sc.nextLine();
			sp = st.split(" ");
			int j;
			switch (sp[0]) {
			case "max":
				for (j = 0; ba.kv[2 * j + 2] != null; j = 2 * j + 2);
				System.out.println(ba.kv[j].key);
				break;
			case "floor":
				System.out.println(ba.floor(sp[1]));
				break;
			case "deleteMin":
				break;
			case "keys":
				ba.inorder(0);
				break;
			case "rank":
				System.out.println(ba.rank(sp[1]));
				break;
			case "get":
				j = ba.contains(sp[1]);
				System.out.println((j==-1)?"null":ba.kv[j].val);
				break;
			case "contains":
				System.out.println(ba.contains(sp[1])>-1);
				break;
			}
		}
	}

}
