package BOJ_21919;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 소수최소공배수_이유빈 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Set<Integer> prime = new HashSet<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i=0; i<n; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      if (isPrime(tmp)) {
        prime.add(tmp);
      }
    }
    if (prime.isEmpty()) {
      bw.write(-1 + "");
    } else {
      long result = 1;
      for (int p : prime) {
        result *= p;
      }
      bw.write(result + "");
    }

    br.close();
    bw.flush();
    bw.close();
  }

  private static boolean isPrime(int t) {
    if (t < 2)
      return false;
    for (int j = 2; j <= Math.sqrt(t); j++) {
      if (t % j == 0)
        return false;
    }
    return true;
  }
}
