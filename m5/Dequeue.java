import java.util.LinkedList;
import java.util.Scanner;

class Dequeue1 {
	LinkedList<Integer> ll = new LinkedList<Integer>();
	public void pushRight(int item) {
		ll.add(item);
	}
	
	public void popLeft() {
		ll.removeFirst();
	}

	public void pushLeft(int item) {
		ll.addFirst(item);
	}

	public void popRight() {
		ll.removeLast();
	}

	public String print() {

		if (ll.isEmpty()) {
			//System.out.println("Hi");
			return "[]";
		}
		String st = "[" + ll.get(0);
		for (int i = 1; i < ll.size(); i++) {
			st = st + ", " + ll.get(i);
		}
		st = st + "]";
		// System.out.println();
		return st;
	}
}

public class Dequeue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, i, data;
		String s;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		Dequeue1 d = new Dequeue1();

		while (scan.hasNext()) {
			s = scan.nextLine();
			//System.out.println(s);
			String[] s1 = s.split(" ");
			//System.out.println(s1[0]);
			switch (s1[0]) {
			case "isEmpty":
				System.out.println(d.ll.isEmpty());
				break;
			case "size":
				System.out.println(d.ll.size());
				break;
			case "pushLeft":
				data = Integer.parseInt(s1[1]);
				d.pushLeft(data);
				System.out.println(d.ll);
				break;
			case "pushRight":
				data = Integer.parseInt(s1[1]);
				d.pushRight(data);
				System.out.println(d.ll);
				break;
			case "popLeft":
				d.popLeft();
				System.out.println(d.print());
				break;
			case "popRight":
				d.popRight();
				System.out.println(d.print());
				break;
			}
		}
		
	}

}
