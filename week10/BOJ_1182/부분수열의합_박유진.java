package BOJ_1182;

import java.io.*;
import java.util.*;

public class 부분수열의합_박유진 {

  static int n, s;
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());

    int[] elements = new int[n];
    boolean[] visited = new boolean[n];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      elements[i] = Integer.parseInt(st.nextToken());
    }

    solu(0, 0, 0, elements, visited);

    System.out.println(answer);
  }

  public static void solu(int nowIdx, int nowSum, int cnt, int[] elements, boolean[] visited) {

    if (nowIdx >= n) {
      return;
    }

    if (nowSum == s && cnt > 0) {
      answer++;
    }

    for (int j = nowIdx; j < n; j++) {

      if (visited[j]) {
        continue;
      }

      visited[j] = true;
      nowSum += elements[j];

      solu(j, nowSum, cnt + 1, elements, visited);

      nowSum -= elements[j];
      visited[j] = false;
    }
  }
}
