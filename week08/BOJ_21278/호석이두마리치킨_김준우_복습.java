package BOJ_21278;

import java.util.Arrays;
import java.util.Scanner;

public class 호석이두마리치킨_김준우_복습 {
  static final int INF = 100000;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    int[][] distance = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      Arrays.fill(distance[i], INF);
      distance[i][i] = 0;
    }

    for (int i = 0; i < M; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      distance[a][b] = 1;
      distance[b][a] = 1;
    }

    for (int i = 1; i <= N; i++) {
      for (int start = 1; start <= N; start++) {
        for (int end = 1; end <= N; end++) {
          distance[start][end] = Math.min(distance[start][end],
              distance[start][i] + distance[i][end]);
        }
      }
    }

    int minSum = INF;
    int bestA = 0, bestB = 0;

    for (int i = 1; i <= N; i++) {
      for (int j = i + 1; j <= N; j++) {
        int total = 0;
        for (int k = 1; k <= N; k++) {
          int toCloset = Math.min(distance[k][i], distance[k][j]);
          total += toCloset * 2;
        }

        if (total < minSum) {
          minSum = total;
          bestA = i;
          bestB = j;
        }
      }
    }
    System.out.println(bestA + " " + bestB + " " + minSum);
  }

}
