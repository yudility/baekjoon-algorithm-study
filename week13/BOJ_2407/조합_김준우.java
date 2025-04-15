package BOJ_2407;

import java.math.BigInteger;
import java.util.Scanner;

public class 조합_김준우 {
  static final int MAX = 100;
  static BigInteger[][] arr = new BigInteger[MAX + 1][MAX + 1];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    for (int i = 0; i <= MAX; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          arr[i][j] = BigInteger.ONE;
        } else {
          arr[i][j] = arr[i - 1][j - 1].add(arr[i - 1][j]);
        }
      }
    }

    System.out.println(arr[n][m]);
  }
}