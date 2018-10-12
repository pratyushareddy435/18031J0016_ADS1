

import java.util.LinkedList;
import java.util.Scanner;

class Steque1 {
	LinkedList<Integer> ll;
	public Steque1(){
		ll = new LinkedList<Integer>();
	}

	public void push(int item) {
		ll.addFirst(item);
	}

	public String pop() {
		return (ll.isEmpty())?"Steque is empty.":(""+ll.removeFirst());
		
	}

	public void enqueue(int item) {
		ll.addLast(item);
	}

	public String print() {

		if (ll.isEmpty()) {

			return "Steque is empty.";
		}
		String st = "" + ll.get(0);
		for (int i = 1; i < ll.size(); i++) {
			st = st + ", " + ll.get(i);
		}
		return st;

	}

	public void removeAll() {
		// TODO Auto-generated method stub
		ll = new LinkedList<Integer>();
	}
}

public class Steque {

	public static void main(String[] args) {
		int n, data;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		Steque1 st = new Steque1();
		int flag = 0;
		do {
			String s = scan.nextLine();
			String[] s1 = s.split(" ");
			switch (s1[0]) {
			case "enqueue":
				data = Integer.parseInt(s1[1]);
				st.enqueue(data);
				System.out.println(st.print());
				break;
			case "push":
				data = Integer.parseInt(s1[1]);
				st.push(data);
				System.out.println(st.print());
				break;
			case "pop":
				st.pop();
				System.out.println(st.print());
				break;
			default:
				st.removeAll();
				if(flag==1)
				System.out.println();
				flag=1;

			}

		} while (scan.hasNext());

		// }

	}
}
