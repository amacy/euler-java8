package euler;

import java.util.ArrayList;
import java.util.List;

public class Problem003 {
  public static final long NUMBER = 600_851_475_143L;

  public static int solve() {
    List<Integer> primes = new ArrayList<Integer>();

    for(int candidate = 1; primes.stream().map(a -> a.longValue()).reduce(1L, (a, b) -> a * b) < NUMBER; candidate++) {
      if(NUMBER % candidate == 0 && isPrime(candidate)) {
        primes.add(candidate);
      }
    }
    return primes.get(primes.size() - 1);
  }

  private static boolean isPrime(int n) {
    for(int i = 2; i < (n / 2); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
