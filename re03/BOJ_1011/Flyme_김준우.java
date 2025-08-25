package BOJ_1011;
import java.util.*;
import java.io.*;

class Flyme_김준우 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    for(int i = 0; i < n; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();

      System.out.println(calMin(x, y));
    }
  }

  static int calMin(int x, int y) {
    int dist = y - x;

    int k = (int) Math.sqrt(dist);
    int answer = 0;
    if (dist == k * k) {
      answer = 2 * k - 1;
    } else if (dist <= k * k + k) {
      answer = 2 * k;
    } else {
      answer = 2 * k + 1;
    }

    return answer;
  }
}
