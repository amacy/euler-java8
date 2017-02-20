package euler;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Problem026 {
  public static final int MAX = 10;

  public static int solve() {
    int largestDenominator = 0;
    int denominatorLength = 0;
    for(int i = 2; i < MAX; i++) {
      BigDecimal result = BigDecimal.valueOf(1.0 / i);
      int length = repeatingDecimalLength(result);
      if(length > denominatorLength) {
        largestDenominator = i;
        denominatorLength = length;
      }
    }
    return largestDenominator;
  }

  private static int repeatingDecimalLength(BigDecimal n) {
    String decimals = n.toString().split("\\.")[1];
    System.out.println(decimals);
    int largestRepeatingDecimalLength = 0;

    for(int startIndex = 0; startIndex < decimals.length(); startIndex++) {
      for(int endIndex = 0; endIndex < decimals.length(); endIndex++) {
        if(startIndex >= endIndex - 1) { continue; }

        String substring = decimals.substring(startIndex, endIndex);
        if(decimals.lastIndexOf(substring) != startIndex) {
          if(validSubstring(substring) && decimals.length() > largestRepeatingDecimalLength) {
            largestRepeatingDecimalLength = decimals.length();
          }
        }
      }
    }

    return largestRepeatingDecimalLength;
  }

  private static boolean validSubstring(String string) {
    for(int startIndex = 0; startIndex < string.length(); startIndex++) {
      for (int endIndex = 0; endIndex < string.length(); endIndex++) {
        if(startIndex >= endIndex - 1) { continue; }

        Set<Character> dedupedChars = new HashSet<Character>();
        for(char c : string.toCharArray()) {
          dedupedChars.add(c);
        }

        if(dedupedChars.size() == 1) { return false; }

        String substring = string.substring(startIndex, endIndex);
        if(string.lastIndexOf(substring) != startIndex) {
          return false;
        }
      }
    }
    return true;
  }
}
