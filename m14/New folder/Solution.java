import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Student implements Comparable<Student> {
	String name, dob;
	int m1, m2, m3, tot;
	String cat;

	public Student(String data[]) {
		this.name = data[0];
		this.dob = data[1];
		this.m1 = Integer.parseInt(data[2]);
		this.m2 = Integer.parseInt(data[3]);
		this.m3 = Integer.parseInt(data[4]);
		this.tot = Integer.parseInt(data[5]);
		this.cat = data[6];
	}

	@Override
	public int compareTo(Student st) {
		if (st.tot == this.tot) {
			if (st.m3 == this.m3) {
				if (st.m2 == this.m2) {
					String sp1[] = this.dob.split("-");
					String sp2[] = st.dob.split("-");
					if (sp1[2].equals(sp1[2])) {
						if (sp1[1].equals(sp1[1])) {
							return Integer.parseInt(sp1[0]) - Integer.parseInt(sp2[0]);
						}
						return Integer.parseInt(sp1[1]) - Integer.parseInt(sp2[1]);
					}
					return Integer.parseInt(sp1[2]) - Integer.parseInt(sp2[2]);
				}
				return st.m2 - this.m2;
			}
			return st.m3 - this.m3;
		}
		return st.tot - this.tot;
	}

	public String toString() {
		return name + "," + tot + "," + cat;
	}
}

public class Solution {
	ArrayList<Student> ast = new ArrayList<Student>();

	public void catfil(String cat, int nc, int cp, int op) {
		int j = 0, k = op;
		for(int i = cp;i < ast.size() && j < nc;i++) {
			if (ast.get(i).cat.equals(cat)) {
				Student st1 = ast.remove(i);
				while (k < cp && st1.tot < ast.get(k).tot)
					k++;
				ast.add(k++, st1);
				cp++;
				j++;
			}
		}
		for (k = op; j < nc; cp++, j++) {
			Student st1 = ast.remove(cp);
			while (st1.tot < ast.get(k).tot)
				k++;
			ast.add(k++, st1);
		}
	}

	public static void main(String[] args) {
		int tst, tse, op, bc, st, scs;
		Scanner sc = new Scanner(System.in);
		Solution sa = new Solution();
		tst = sc.nextInt();
		tse = sc.nextInt();
		op = sc.nextInt();
		bc = sc.nextInt();
		st = sc.nextInt();
		scs = sc.nextInt();
		for (int i = 0; i < tst; i++) {
			String str = sc.next();
			sa.ast.add(new Student(str.split(",")));
		}
		Collections.sort(sa.ast);
		for (int i = 0; i < tst; i++)
			System.out.println(sa.ast.get(i));
		System.out.println();
		int cp = op;
		sa.catfil("BC", bc, cp, op);
		cp += bc;
		sa.catfil("ST", st, cp, op);
		cp += st;
		sa.catfil("SC", scs, cp, op);
		for (int i = 0; i < tse; i++)
			System.out.println(sa.ast.get(i));
	}
}