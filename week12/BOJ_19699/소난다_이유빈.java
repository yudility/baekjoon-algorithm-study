package BOJ_19699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 소난다_이유빈 {

  static int n;
  static int m;
  static boolean[] visited;
  static int[] h;
  static HashSet<Integer> set = new HashSet<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    h = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i=0; i<n; i++) {
      h[i] = Integer.parseInt(st.nextToken());
    }

    visited = new boolean[n];

    dfs(0,0,0);

    if (set.isEmpty()) {
      System.out.println(-1);
    } else {
      ArrayList<Integer> result = new ArrayList<>(set);
      Collections.sort(result);

      for (int i=0; i<result.size(); i++) {
        System.out.print(result.get(i) + " ");
      }
    }

  }

  static void dfs(int depth, int sum, int start) {
    if (depth == m) {
      if (isPrime(sum)) {
        set.add(sum);
        return;
      }
    }
    for (int j=start; j<n; j++) {
      if (!visited[j]) {
        visited[j] = true;
        dfs(depth+1, sum+h[j], j+1);
        visited[j] = false;
      }
    }
  }

  static boolean isPrime(int k) {
    for (int i=2; i<=Math.sqrt(k); i++) {
      if (k % i == 0) {
        return false;
      }
    }
    return true;
  }

}
