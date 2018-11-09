import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
  HashMap<String, Integer> magazineMap;
  HashMap<String, Integer> noteMap;

  public Solution(String magazine, String note) { 
    Collection<String> magazineStrings = Arrays.asList(magazine.split(" "));
    Collection<String> noteStrings = Arrays.asList(note.split(" "));
    magazineMap = new HashMap<String,Integer>();
    noteMap = new HashMap<String,Integer>();

   

    for(String value : magazineStrings) {
      if (magazineMap.get(value) == null) {
        magazineMap.put(value, 0);  
      }
      Integer currentValue = magazineMap.get(value);
      currentValue++;
      magazineMap.put(value,currentValue);
    }

    for(String value : noteStrings) {
      if (noteMap.get(value) == null) {
        noteMap.put(value, 0);  
      }
      Integer currentValue = noteMap.get(value);
      currentValue++;
      noteMap.put(value,currentValue);
    }
  }

  public boolean solve() {
    for(String ransomWord : noteMap.keySet()) {
      Integer ransomValue   = noteMap.get(ransomWord);
      Integer magazineValue = magazineMap.get(ransomWord);

      if (magazineValue == null || ransomValue > magazineValue) {
        return false;  
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int n = scanner.nextInt();
    scanner.nextLine();
    Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
    scanner.close();
    boolean answer = s.solve();
    if(answer)
      System.out.println("Yes");
    else System.out.println("No");
  }
}


