package BOJ_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_김준우 {
  static int N, S;
  static int[] arr;
  static int count = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0, 0);
    if (S == 0) {
      count--; // 공집합을 제외하기 위해
    }
    System.out.println(count);
  }

  static void dfs(int depth, int sum) {
    if (depth == N) {
      if (sum == S) {
        count++;
      }
      return;
    }
    dfs(depth + 1, sum + arr[depth]);

    dfs(depth + 1, sum); //공집합까지 포함하게 된다
  }
}
