package BOJ_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추_한성지 {

  static int T;    // 테스트 케이스 개수
  static int M, N, K;     // M: 가로, N: 세로, K: 배추 개수
  static int[][] cabbage; // 배추 좌표
  static boolean[][] visited; // 방문 여부
  static int[] dx = {0, 0, 1, -1};    // 상하좌우 이동
  static int[] dy = {1, -1, 0, 0};
  static int count;   // 지렁이 수

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    T = Integer.parseInt(br.readLine());

    // 테스트 T번
    for (int i = 0; i < T; i++) {
      count = 0;  // 지렁이 수 초기화
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      cabbage = new int[M][N];
      visited = new boolean[M][N];

      // 배추밭 정보 채워넣기기
      for (int j = 0; j < K; j++) {
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        cabbage[X][Y] = 1;
      }

      // 모든 좌표 순회하며 지렁이 수 카운트
      for (int x = 0; x < M; x++) {
        for (int y = 0; y < N; y++) {
          if (!visited[x][y] && cabbage[x][y] == 1) { // 방문한 적 없고, 배추 심어져 있는 경우우
            dfs(x, y);
            count++;
          }
        }
      }

      System.out.println(count);
    }
  }

  static void dfs(int x, int y) {
    visited[x][y] = true;

    for (int i = 0; i < 4; i++) {
      int cx = x + dx[i];
      int cy = y + dy[i];

      if (cx >= 0 && cy >= 0 && cx < M && cy < N) {    // 배추밭 범위 확인
        if (!visited[cx][cy] && cabbage[cx][cy] == 1) { // 방문한적 없고 배추 있을 경우
          dfs(cx, cy);
        }
      }
    }
  }
}
