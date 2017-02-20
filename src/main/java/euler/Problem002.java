package euler;

import java.util.ArrayList;
import java.util.List;

public class Problem002 {
  public static int solve() {
    int max = 4_000_000;
    int acc = 3;
    List<Integer> data = new ArrayList<Integer>();
    data.add(1);
    data.add(2);

    while(acc <= max) {
      data.add(acc);
      int arrayLength = data.size();
      int x = data.get(arrayLength - 1);
      int y = data.get(arrayLength - 2);
      acc = x + y;
    }
    return data.stream().filter(n -> n % 2 == 0).reduce(0, (Integer::sum));
  }
}
