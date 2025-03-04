package BOJ_1669;

import java.util.Scanner;

public class 멍멍이쓰다듬기_김준우 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int monkey = sc.nextInt();
    int dog = sc.nextInt();

    int input = Math.abs(monkey - dog);

    if (input == 0) {
      System.out.println(0);
      return;
    }
    int sqrt = (int) Math.sqrt(input);
    int square = sqrt * sqrt;

    if (square == input) { // 완전 제곱수일때
      System.out.println(2 * sqrt - 1);
      return;
    }

    // 완전제곱수가 아니라면 ..? 이때가 중요
    int remain = input - square;
    int count = 2 * sqrt - 1;
    if (remain <= sqrt) {
      count += 1;
    } else {
      count += 2;
    }
    System.out.println(count);
  }
}
