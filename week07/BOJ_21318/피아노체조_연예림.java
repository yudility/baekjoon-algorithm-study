package BOJ_21318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피아노체조_연예림 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    int[] paper = new int[N+1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <=N; i++) {
      paper[i] = Integer.parseInt(st.nextToken());
    }

    int[] check = new int[N+1];
    for (int i = 1; i <N; i++) {
      if (paper[i] > paper[i+1]) {
        check[i] = check[i-1] + 1;
      } else {
        check[i] = check[i-1];
      }
    }
    check[N] = check[N-1];

    int Q = Integer.parseInt(br.readLine());
    for (int i = 1; i <=Q; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      int minus = 0;
      if (y+1 < paper.length && paper[y] > paper[y+1]) {
        minus = 1;
      }
      sb.append(check[y] - check[x-1] - minus).append("\n");
    }
    System.out.println(sb);
  }
}
