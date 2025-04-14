package BOJ_3584;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 가장가까운공통조상_김준우_복습 {
  static int T, N;
  static Map<Integer, Integer> parentMap;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      N = Integer.parseInt(br.readLine());
      parentMap = new HashMap<>();

      for (int i = 1; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int parent = Integer.parseInt(st.nextToken());
        int child = Integer.parseInt(st.nextToken());
        parentMap.put(child, parent);
      }

      StringTokenizer st = new StringTokenizer(br.readLine());
      int node1 = Integer.parseInt(st.nextToken());
      int node2 = Integer.parseInt(st.nextToken());

      sb.append(findCA(node1, node2)).append("\n");
    }
    System.out.println(sb);
  }

  static int findCA(int node1, int node2) {
    Set<Integer> set = new HashSet<>();

    while (parentMap.containsKey(node1)) {
      set.add(node1);
      node1 = parentMap.get(node1);
    }
    set.add(node1);

    while (!set.contains(node2)) {
      node2 = parentMap.get(node2);
    }
    return node2;
  }

}
