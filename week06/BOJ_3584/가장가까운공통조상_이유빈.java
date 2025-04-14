package BOJ_3584;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장가까운공통조상_이유빈 {

  static int t, n;
  static int[] parent;
  static boolean[] visit;
  static StringTokenizer st;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      n = Integer.parseInt(br.readLine());
      parent = new int[n+1];
      visit = new boolean[n+1];

      for (int i=1; i<n; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        parent[y] = x;
      }

      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      solution(x, y);
    }
  }

  static void solution(int x, int y) {
    while (x > 0) {
      visit[x] = true;
      x = parent[x];
    }

    while (y > 0) {
      if (visit[y]) {
        System.out.println(y);
        break;
      }
      y = parent[y];
    }
  }
}
