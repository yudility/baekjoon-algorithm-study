package BOJ_21921;

import java.util.Scanner;

public class 블로그_김준우 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x = sc.nextInt();
    int[] visitors = new int[n];

    for (int i = 0; i < n; i++) {
      visitors[i] = sc.nextInt();
    }

    int sum = 0; // X일 동안의 방문자 수의 합
    for (int i = 0; i < x; i++) {
      sum += visitors[i];
    }

    int max = sum; // sum 값 중 최대값
    int count = 1;
    for (int i = x; i < n; i++) {
      sum = sum - visitors[i - x] + visitors[i];

      if (sum > max) {
        max = sum; // max 값 갱신
        count = 1;
      } else if (sum == max) { // 같은 구간이라는 의미
        count++;
      }
    }

    // 만약 최대 방문자 수가 0인 경우 SAD 출력
    System.out.println(max == 0 ? "SAD" : max + "\n" + count);
  }
}
