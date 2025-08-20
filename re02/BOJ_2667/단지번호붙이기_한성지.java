package BOJ_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class 단지번호붙이기_한성지 {

  static int N;  // 지도 길이 및 높이
  static int[][] map;    // 지도 값
  static boolean[][] visit;    // 방문 여부
  static int[] dx = {0, 1, 0, -1};    // 상하좌우 좌표
  static int[] dy = {1, 0, -1, 0};
  static int houseCount;    // 단지 내 집 수
  static ArrayList<Integer> answer = new ArrayList<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    visit = new boolean[N][N];
    for (int i = 0; i < N; i++) {    // 지도 채우기
      String[] arr = br.readLine().split("");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(arr[j]);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (!visit[i][j] && map[i][j] == 1) {    // 방문한 적 없고, 집 있을 경우
          houseCount = 0;
          dfs(i, j);
          answer.add(houseCount);
        }
      }
    }

    Collections.sort(answer);

    for (int n : answer) {
      sb.append(n).append("\n");
    }

    System.out.println(answer.size());
    System.out.print(sb);
  }

  static void dfs(int x, int y) {
    visit[x][y] = true;    // 방문 표시
    houseCount++;

    for (int i = 0; i < 4; i++) {    // 상하좌우 이동
      int cx = x + dx[i];
      int cy = y + dy[i];

      if (cx >= 0 && cy >= 0 && cx < N && cy < N) {    // 지도 내의 좌표이고
        if (!visit[cx][cy] && map[cx][cy] == 1) {    // 방문한적 없으며, 집이 있을 때
          dfs(cx, cy);    // 재귀호출을 통한 깊이 탐색
        }
      }
    }
  }
}