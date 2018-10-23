
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Teams implements Comparable<Teams> {
	String Tname;
	int wins;
	int losses;
	int draws;

	Teams(String Tname, int wins, int losses, int draws) {
		this.Tname = Tname;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
	}

	@Override
	public int compareTo(Teams Ts) {
		if (this.wins == Ts.wins) {
			if (this.losses == Ts.losses) {
				return Ts.draws - this.draws;
			} else {
				return this.losses - Ts.losses;
			}
		} else {
			return Ts.wins - this.wins;
		}

	}
}

public class Solution {
	public static void main(String args[]) {
		ArrayList<Teams> al = new ArrayList<>();
		Scanner scn = new Scanner(System.in);
		do {
			String st = scn.nextLine();
			String sp[] = st.split(",");
			al.add(new Teams(sp[0], Integer.parseInt(sp[1]), Integer.parseInt(sp[2]), Integer.parseInt(sp[3])));
		} while (scn.hasNext());
		Collections.sort(al);
		// System.out.println(al);
		String st = "" + al.get(0).Tname;
		for (int i = 1; i < al.size(); i++) {
			st = st + ","+ al.get(i).Tname;
			
		}
		System.out.print(st);
		// System.out.print(ts.Tname+",");
	}
}
