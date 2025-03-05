package BOJ_2615;

import java.util.Scanner;

public class 오목_김준우 {
    static int n = 19;
    static int[][] board = new int[n][n];
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    int color = board[i][j];
                    for (int dir = 0; dir < 4; dir++) {
                        int count = 1;
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];

                        while (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == color) {
                            count++;
                            nx += dx[dir];
                            ny += dy[dir];
                        }

                        if (count == 5) {
                            int prevX = i - dx[dir];
                            int prevY = j - dy[dir];
                            int nextX = nx;
                            int nextY = ny;

                            if ((prevX < 0 || prevX >= n || prevY < 0 || prevY >= n || board[prevX][prevY] != color)
                                    && (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || board[nextX][nextY] != color)) {
                                System.out.println(color);
                                System.out.println((i + 1) + " " + (j + 1));
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}
