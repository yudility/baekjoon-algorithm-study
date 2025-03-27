package BOJ_3584;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장가까운공통조상_한성지_복습 {

  static int T;   // 테스트 케이스 수
  static int N;   // 노드의 수
  static int[] parent;  // 부모 저장
  static boolean[] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {

      N = Integer.parseInt(br.readLine());
      parent = new int[N + 1];

      for (int j = 0; j < N - 1; j++) {
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());   // 부모
        int B = Integer.parseInt(st.nextToken());   // 자식

        parent[B] = A;  // 자식 인덱스에 부모 저장
      }

      // 공통 조상을 구할 두 노드
      st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());

      cal(n1, n2);
    }
  }

  static void cal(int n1, int n2) {
    visit = new boolean[N + 1];
    
    while (n1 > 0){
      visit[n1] = true;
      n1 = parent[n1];
    }

    while (n2 > 0){
      if (visit[n2]) {
        System.out.println(n2);
        break;
      }
      n2 = parent[n2];
    }
  }
}