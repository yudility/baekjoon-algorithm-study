package BOJ_2615;

import java.util.Scanner;

public class 오목_김준우_복습 {
  static int N = 19;
  static int[][] arr = new int[N][N];
  static int[] dx = {1, 0, 1, -1};
  static int[] dy = {0, 1, 1, 1};
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (arr[i][j] != 0) {
          int color = arr[i][j];

          for (int dir = 0; dir < 4; dir++) {
            int count = 1;
            int nx = i + dx[dir];
            int ny = j + dy[dir];

            while (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == color) {
              count++;
              nx += dx[dir];
              ny += dy[dir];
            }

            if (count != 5) continue;

            int prevX = i - dx[dir];
            int prevY = j - dy[dir];
            int nextX = nx;
            int nextY = ny;

            if ((prevX >= 0 && prevX < N && prevY >= 0 && prevY < N && arr[prevX][prevY] == color) ||
                (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && arr[nextX][nextY] == color)) {
              continue;
            }

            System.out.println(color);
            System.out.println((i + 1) + " " + (j + 1));
            return;
          }
        }
      }
    }
    System.out.println(0);
  }
}
