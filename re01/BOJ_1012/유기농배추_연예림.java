package BOJ_1012;

import java.io.*;
import java.util.*;

public class 유기농배추_연예림
{
  public static int[][] links;
  public static boolean[][] visited;
  public static int[] dx = {0 , 0, 1, -1};
  public static int[] dy = {1, -1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    // 테스트 케이스 수
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      // 가로, 세로, 연결 개수
      st = new StringTokenizer(br.readLine());
      int row = Integer.parseInt(st.nextToken());
      int height = Integer.parseInt(st.nextToken());
      int inputs = Integer.parseInt(st.nextToken());

      // 연결 배열 생성
      links = new int[row][height];
      // 방문 배열 생성
      visited = new boolean[row][height];

      // 연결 정보 입력
      for (int n = 0; n < inputs; n++) {
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        links[n1][n2] = 1;
      }

      // result: 트리 개수 구하기 (지렁이 수)
      int result = 0;

      // 전체 탐색 시작
      for (int i = 0; i < links.length; i++){
        for (int j = 0; j < links[0].length; j++) {
          // -> 이미 방문한 노드는 pass
          // -> 방문 하지 않은 노드는 result + 1 후 탐색 시작
          if (links[i][j] == 1 && !visited[i][j]) {
            result++;
            check(i,j);
          }
        }
      }

      System.out.println(result);
    }
  }

  public static void check(int n, int m) {

    Deque<int[]> store = new LinkedList<>();
    store.add(new int[]{n,m});

    while(!store.isEmpty()) {
      int[] lt = store.poll();
      int x = lt[0];
      int y = lt[1];

      // 방문하지 않았다면 방문 및 주변 탐색
      if (links[x][y] == 1 && !visited[x][y]) {
        visited[x][y] = true;

        // 사면체크
        for (int i = 0; i < 4; i++) {
          int nextX = x + dx[i];
          int nextY = y + dy[i];
          // 범위 확인
          if (0 <= nextX && nextX < links.length && 0 <= nextY && nextY < links[0].length) {
            // 방문 확인
            if (links[nextX][nextY] == 1 && !visited[nextX][nextY]) {
              store.add(new int[]{nextX, nextY});
            }
          }
        }
      }

    }
  }
}
