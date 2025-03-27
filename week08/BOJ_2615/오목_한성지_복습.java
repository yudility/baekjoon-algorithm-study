package BOJ_2615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오목_한성지_복습 {

  static int[][] board;
  static int[] dirX;
  static int[] dirY;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    board = new int[20][20];  // 바둑판

    // 방향(왼쪽, 우측 하단 대각선, 아래, 좌측 하단 대각선)
    dirX = new int[]{1, 1, 0, -1};
    dirY = new int[]{0, 1, 1, 1};

    // 바둑알 위치 저장
    for (int i = 1; i <= 19; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= 19; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 오목 검사
    // 왼쪽에서 오른쪽으로 검사
    for (int j = 1; j <= 19; j++) {
      for (int i = 1; i <= 19; i++) {
        if (board[i][j] != 0) {
          for (int dir = 0; dir < 4; dir++) {
            int x = i;
            int y = j;
            int cnt = 1;  // 현재 연속 오목돌 개수

            // 네방향 검사
            while (true) {
              x += dirX[dir];
              y += dirY[dir];
              if (x > 0 && x <= 19 && y > 0 && y <= 19) {
                if (board[i][j] == board[x][y]) {
                  cnt++;
                } else {
                  break;
                }
              } else {
                break;
              }
            }

            // 검사하던 돌로 돌아옴
            x = i;
            y = j;

            // 반대 방향 검사
            while (true) {
              x -= dirX[dir];
              y -= dirY[dir];
              if (x > 0 && x <= 19 && y > 0 && y <= 19) {
                if (board[i][j] == board[x][y]) {
                  cnt++;
                } else {
                  break;
                }
              } else {
                break;
              }
            }

            if (cnt == 5) {
              System.out.println(board[i][j]);
              System.out.println(i + " " + j);
              return;
            }
          }
        }
      }
    }
    System.out.println(0);
  }
}