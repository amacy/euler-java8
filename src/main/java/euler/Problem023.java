package euler;

import com.google.common.collect.Range;

import javax.jnlp.IntegrationService;
import java.util.*;

public class Problem023 {
  public static final int MAX = 28123;

  public static int solve() {
    List<Integer> abundantNumbers = new ArrayList<Integer>();

    for(int i = 1; i <= MAX; i++) {
      List<Integer> emptyList = new ArrayList<Integer>();
      emptyList.add(0);
      int sumOfFactors = factors(i).orElse(emptyList).stream().reduce(0, Integer::sum);

      if(sumOfFactors > i) { abundantNumbers.add(i); }
    }
    Set<Integer> sumsOfAbundants = new HashSet<Integer>();

    for(Integer x : abundantNumbers) {
      for(Integer y : abundantNumbers) {
        int sum = x + y;
        if(sum <= MAX) { sumsOfAbundants.add(sum); }
      }
    }

    List<Integer> notSumsOfAbundants = new ArrayList<Integer>();
    for(int i = 1; i <= MAX; i++) {
      if(!sumsOfAbundants.contains(i)) { notSumsOfAbundants.add(i); }
    }
    System.out.println(abundantNumbers);
    System.out.println(sumsOfAbundants);
    System.out.println(notSumsOfAbundants);
    return notSumsOfAbundants.stream().reduce(0, Integer::sum);
  }

  private static Optional<List<Integer>> factors(int n) {
    List<Integer> payload = new ArrayList<Integer>();
    for(int i = 1; i <= (n / 2); i++) {
      if((n % i) == 0) { payload.add(i); }
    }
    if(payload.size() > 0) {
      return Optional.of(payload);
    } else {
      return Optional.empty();
    }
  }
}
