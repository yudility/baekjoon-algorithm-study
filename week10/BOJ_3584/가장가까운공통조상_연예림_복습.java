package BOJ_3584;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 가장가까운공통조상_연예림_복습 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(br.readLine());
      int[] parent = new int[n+1];

      for (int j = 0; j < n-1; j++) {
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        parent[c] = p;
      }

      st = new StringTokenizer(br.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());

      // 찾기
      System.out.println(cal(parent,node1,node2));
    }
  }

  public static int cal(int[] parent, int num1, int num2) {
    Set<Integer> num1Set = new HashSet<>();
    Set<Integer> num2Set = new HashSet<>();

    num1Set.add(num1);
    num2Set.add(num2);
    int nextIdx1 = num1;
    int nextIdx2 = num2;

    while (true) {
      nextIdx1 = parent[nextIdx1];
      if (num2Set.contains(nextIdx1)) {
        return nextIdx1;
      } else {
        num1Set.add(nextIdx1);
      }
      nextIdx2 = parent[nextIdx2];
      if (num1Set.contains(nextIdx2)) {
        return nextIdx2;
      } else {
        num2Set.add(nextIdx2);
      }
    }
  }

}
