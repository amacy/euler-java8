package euler;

import org.hamcrest.core.CombinableMatcher;

import java.util.*;

public class Problem031 {
  public static final Integer[] COINS = {1, 2, 5, 10, 20, 50, 100, 200};
  public static final int MAX = 200;
  public static final Map<Integer, List<Integer>>  MAX_COMBINATIONS = maxCombinations();
  public static final HashSet<HashSet<Integer>> PERMUTATIONS = permutations();

  public static int solve() {
    int total = 0;
    Set<HashMap<Integer, Integer>> finishedCombinations = new HashSet<HashMap<Integer, Integer>>();

    for(HashSet<Integer> permutation : PERMUTATIONS) {
      List<Combination> unfinishedCombinations = new ArrayList<Combination>();
      for (int coin : permutation) {
        for (int count = 1; count * coin <= MAX; count++) {
          // generate all possible permutations given the current coin
          Combination combination = new Combination();
          combination.add(coin, count);
          // if the combination is done, add it to the finished one and remove it from the current one
          total = combination.total();
          if (total == MAX) {
            finishedCombinations.add(combination.toHashMap());
            combination = new Combination();
          } else {
            unfinishedCombinations.add(combination);
          }
          // move onto the next coin following the same steps
        }
      }
    }
    return finishedCombinations.size();
  }

  private static List<Integer> combinations(int coin, int max) {
    List<Integer> payload = new ArrayList<Integer>();
    for(int count = 0; coin * count <= max; count++) { payload.add(count); }
    return payload;
  }

  private static Map<Integer, List<Integer>>  maxCombinations() {
    HashMap<Integer, List<Integer>> payload = new HashMap<Integer, List<Integer>>();
    for(int coin : COINS) { payload.put(coin, combinations(coin, MAX)); }
    return payload;
  }

  private static HashSet<HashSet<Integer>> permutations() {
    HashSet<HashSet<Integer>> payload = new HashSet<HashSet<Integer>>();
    for(int coin_1 : COINS) {
      HashSet<Integer> currentPermutation = new HashSet<Integer>();
      for(int coin_2 : COINS) {
        for(int coin_3 : COINS) {
          for(int coin_4 : COINS) {
            for(int coin_5 : COINS) {
              for(int coin_6 : COINS) {
                for(int coin_7 : COINS) {
                  for(int coin_8 : COINS) {
                    currentPermutation.add(coin_1);
                    currentPermutation.add(coin_2);
                    currentPermutation.add(coin_3);
                    currentPermutation.add(coin_4);
                    currentPermutation.add(coin_5);
                    currentPermutation.add(coin_6);
                    currentPermutation.add(coin_7);
                    currentPermutation.add(coin_8);
                    if(currentPermutation.size() == 8) { payload.add(currentPermutation); }
                  }
                }
              }
            }
          }
        }
      }
    }
    return payload;
  }

  public static class Combination {
    private int onePence;
    private int twoPence;
    private int fivePence;
    private int tenPence;
    private int twentyPence;
    private int fiftyPence;
    private int hundredPence;

    private void setOnePence(int onePence) { this.onePence = onePence; }
    private void setTwoPence(int twoPence) { this.twoPence = twoPence; }
    private void setFivePence(int fivePence) { this.fivePence = fivePence; }
    private void setTenPence(int tenPence) { this.tenPence = tenPence; }
    private void setTwentyPence(int twentyPence) { this.twentyPence = twentyPence; }
    private void setFiftyPence(int fiftyPence) { this.fiftyPence = fiftyPence; }
    private void setHundredPence(int hundredPence) { this.hundredPence = hundredPence; }

    private int getOnePence() { return onePence; }
    private int getTwoPence() { return twoPence; }
    private int getFivePence() { return fivePence; }
    private int getTenPence() { return tenPence; }
    private int getTwentyPence() { return twentyPence; }
    private int getFiftyPence() { return fiftyPence; }
    private int getHundredPence() { return hundredPence; }

    public int total() {
      return getOnePence() + getTwoPence() + getFivePence() + getTenPence() + getTwentyPence() + getFiftyPence() + getHundredPence();
    }

    public void add(int coin, int count) throws RuntimeException {
      if(coin == 1) {
        for(int times = 1; times <= count; times++) { setOnePence(coin); }
      } else if(coin == 2) {
        for(int times = 1; times <= count; times++) { setTwoPence(coin); }
      } else if(coin == 5) {
        for(int times = 1; times <= count; times++) { setFivePence(coin); }
      } else if(coin == 10) {
        for(int times = 1; times <= count; times++) { setTenPence(coin); }
      } else if(coin == 20) {
        for(int times = 1; times <= count; times++) { setTwentyPence(coin); }
      } else if(coin == 50) {
        for(int times = 1; times <= count; times++) { setFiftyPence(coin); }
      } else if(coin == 100) {
        for(int times = 1; times <= count; times++) { setHundredPence(coin); }
      } else {
        throw new RuntimeException("Unexpected coin");
      }
    }

    public HashMap<Integer, Integer> toHashMap() {
      HashMap<Integer, Integer> payload = new HashMap<Integer, Integer>();
      payload.put(1, getOnePence());
      payload.put(2, getTwoPence());
      payload.put(5, getFivePence());
      payload.put(10, getTenPence());
      payload.put(20, getTwentyPence());
      payload.put(50, getFiftyPence());
      payload.put(100, getHundredPence());
      return payload;
    }
  }
}
