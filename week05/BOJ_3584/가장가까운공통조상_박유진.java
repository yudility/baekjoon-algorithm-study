package BOJ_3584;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class 가장가까운공통조상_박유진 {
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());

    for(int i = 0; i<t; i++) {
      int n = Integer.parseInt(br.readLine());
      boolean[] visited = new boolean[n+1];
      int[] parents = new int[n+1];


      for (int j = 0; j<n-1; j++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        parents[a] = b;
      }
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      solution(parents, visited, x, y);
    }

    System.out.println(sb);
  }
  static void solution(int[] parents ,boolean[] visited ,int x, int y) {

    while(x > 0){
      visited[x] = true;
      x = parents[x];
    }
    while(y > 0){
      if (visited[y]){
        sb.append(y).append("\n");
      }
      y = parents[y];
    }

  }
}
