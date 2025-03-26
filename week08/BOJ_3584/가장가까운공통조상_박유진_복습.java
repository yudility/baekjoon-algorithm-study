package BOJ_3584;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장가까운공통조상_박유진_복습 {
  static int N;
  static int[] p;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int t = Integer.parseInt(br.readLine());

    for(int i = 0; i<t; i++) {
      N = Integer.parseInt(br.readLine());

      p = new int[N+1];

      for (int j = 0; j<N-1; j++) {
        st = new StringTokenizer(br.readLine());
        int pa = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        p[c]=pa;
      }
      st = new StringTokenizer(br.readLine());
      int a_node = Integer.parseInt(st.nextToken());
      int b_node = Integer.parseInt(st.nextToken());

      visited = new boolean[N+1];
      total_parent(a_node);
      System.out.println(same_parent(b_node));
    }
  }

  //전체 부모를 구해라
  public static void total_parent(int a_node) {

    int c = a_node;
    while(c!=0) {
      visited[c] = true;
      c=p[c];
    }
  }

  //같은 부모가 있는지 확인
  public static int same_parent(int b_node) {

    int c = b_node;
    int result = 0;

    while(c!=0) {
      if(visited[c]) {
        result = c;
        break;
      }
      c = p[c];
    }
    return result;
  }
}
