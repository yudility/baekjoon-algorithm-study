package BOJ_2422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 한윤정_이유빈 {
  static int n, m;
  static boolean[][] cannotMix;
  static int cnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    cannotMix = new boolean[n+1][n+1];

    for (int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      cannotMix[a][b] = true;
      cannotMix[b][a] = true;
    }

    findCombinations();
    System.out.println(cnt);

  }

  static void findCombinations() {
    for (int i=1; i<=n; i++) {
      for (int j=i+1; j<=n; j++) {
        if (cannotMix[i][j]) continue;
        for (int k = j+1; k<=n; k++) {
          if (cannotMix[i][k] || cannotMix[k][j]) continue;
          cnt++;
        }
      }
    }
  }
}
