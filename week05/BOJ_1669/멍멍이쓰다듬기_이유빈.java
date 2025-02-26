package BOJ_1669;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 멍멍이쓰다듬기_이유빈 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int sub = y - x;

    if (sub == 0) {
      System.out.println(0);
      return;
    }

    long n = (long) Math.sqrt(sub);
    long ans = 2 * n - 1;
    sub -= n * n;

    while (sub > 0) {
      for (long i=n; 1<=i; i--) {
        if (i<=sub) {
          ans += 1;
          sub -= i;
          break;
        }
        else continue;
      }
    }
    System.out.println(ans);
  }
}
