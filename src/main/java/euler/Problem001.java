package euler;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

public class Problem001 {
  public static int solve() {
    Range<Integer> data = Range.open(0, 1000);
    return ContiguousSet.create(data, DiscreteDomain.integers()).stream().filter(n -> n % 3 == 0 || n % 5 == 0).reduce(0, Integer::sum);
  }
}