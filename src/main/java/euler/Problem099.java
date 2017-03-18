package euler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem099 {
  public static int solve() {
    double largestLog = 0;
    int largestLogLineNumber = 0;
    int currentLineNumber = 0;

    Path filepath = Paths.get("src", "main", "config", "p099_base_exp.txt");

    List<Double> logs = null;
    try (Stream<String> lines = Files.lines(filepath)) {
      logs = lines.map(line -> {
        String[] parts = line.split(",");
        int base = Integer.parseInt(parts[0]);
        int exponent = Integer.parseInt(parts[1]);

        return Math.log(Math.pow(base, exponent));
      }).collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }

    for(Double candidate : logs) {
      if(candidate > largestLog) {
        largestLog = candidate;
        largestLogLineNumber = currentLineNumber;
      } else {
        currentLineNumber++;
      }
    }
    return largestLogLineNumber;
  }
}