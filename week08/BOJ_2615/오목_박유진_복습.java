package BOJ_2615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오목_박유진_복습 {

  static int[] dy = {0, 1, 1, 1};
  static int[] dx = {1, 1, 0, -1};
  static int[][] map = new int[21][21];
  static int[][][] memo = new int[21][21][4];


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    //입력 받기
    for (int i = 1; i <= 19; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= 19; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(findWinner());

  }
  private static String findWinner() {
    for (int j = 1; j <= 19; j++) {
      for (int i = 1; i <= 19; i++) {
        if (map[i][j] != 0) { // 0이면 놓지 않은 곳
          for (int d = 0; d < 4; d++) { // 4방향 탐색
            if (memo[i][j][d] == 0 && calc(i, j, d, map[i][j]) == 5) { //해당 방향에 방문하지 않았고, calc 결과가 5라면(5개돌이라면)
              return map[i][j] + "\n" + i + " " + j + "\n";
            }
          }
        }
      }
    }
    return "0"; // 이긴사람 없음
  }

  private static int calc(int x, int y, int dir, int color) {
    // 다음 방향 탐색
    int nx = x + dx[dir];
    int ny = y + dy[dir];

    if (map[nx][ny] == color) { // 같은 색상이라면
      return memo[nx][ny][dir] = calc(nx, ny, dir, color) + 1; // 해당 방향 재귀함수로 들어가서 + 1
    }
    return 1; //같은 색상이 아니라면 이전 것 까지만이므로 1반환
  }
}
