

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Teams  {
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

	
}

public class Solution{
	public static void main(String args[]) {

		ArrayList<Teams> al = new ArrayList<>();
		Scanner scn = new Scanner(System.in);
		do {
			String st = scn.nextLine();
			String sp[] = st.split(",");
			al.add(new Teams(sp[0], Integer.parseInt(sp[1]), Integer.parseInt(sp[2]), Integer.parseInt(sp[3])));
			for (int i = 1; i < al.size(); i++) {
				for (int j = i; j > 0; j--) {
					if (al.get(j - 1).wins < al.get(j).wins) 
						al.add(j, al.remove(j - 1));
					else if(al.get(j - 1).wins == al.get(j).wins && al.get(j - 1).losses > al.get(j).losses) 
						al.add(j, al.remove(j - 1));
					else if(al.get(j - 1).losses == al.get(j).losses && al.get(j - 1).draws<al.get(j).draws) 
							al.add(j, al.remove(j - 1));
					else 
						break;
				}
			}
			
		} while (scn.hasNext());
	
		// System.out.println(al);
		String st = "" + al.get(0).Tname;
		for (int i = 1; i < al.size(); i++) {
			st = st + "," + al.get(i).Tname;

		}
		System.out.print(st);
		// System.out.print(ts.Tname+",");
	}
}