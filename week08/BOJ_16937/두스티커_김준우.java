package BOJ_16937;

import java.util.Scanner;

public class 두스티커_김준우 {
  static int H,W, N;

  static int[][] arr;

  static int answer = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    H = sc.nextInt();
    W = sc.nextInt();
    N = sc.nextInt();

    arr = new int[N][2];

    for (int i = 0; i < N; i++) {
      arr[i][0] = sc.nextInt(); // 높이
      arr[i][1] = sc.nextInt(); // 너비
    }

    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        check(i, j);
      }
    }

    System.out.println(answer);
  }

  static void check(int i, int j) {
    int[] a1 = arr[i];
    int[] a2 = arr[j];

    int[][] b1 = {{a1[0], a1[1]}, {a1[1], a1[0]}};
    int[][] b2 = {{a2[0], a2[1]}, {a2[1], a2[0]}};

    for (int[] a : b1) {
      for (int[] b : b2) {
        int h1 = a[0], w1 = a[1];
        int h2 = b[0], w2 = b[1];

        if (Math.max(h1, h2) <= H && (w1 + w2) <= W) {
          answer = Math.max(answer, h1 * w1 + h2 * w2);
        }

        if ((h1 + h2) <= H && Math.max(w1, w2) <= W) {
          answer = Math.max(answer, h1 * w1 + h2 * w2);
        }
      }
    }
  }
}
