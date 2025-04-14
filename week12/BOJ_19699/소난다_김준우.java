package BOJ_19699;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class 소난다_김준우 {
  static int N, M;
  static int[] cows;
  static Set<Integer> result = new HashSet<>();

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    cows = new int[N];

    for (int i = 0; i < N; i++) {
      cows[i] = sc.nextInt();
    }

    findCows(0, 0, 0);
    // 정렬을 위한 자료구조
    List<Integer> forSort = new ArrayList<>(result);
    Collections.sort(forSort);

    if (forSort.isEmpty()) {
      System.out.println("-1");
    } else {
      for (Integer i : forSort) {
        System.out.print(i + " ");
      }
    }
  }

  /*
   * depth : 현재까지 선택한 소의 수 (재귀 깊이)
   * start : 다음에 선택할 소의 시작 인덱스
   * sum   : 지금까지 선택한 소들의 몸무게 합
   */
  static void findCows(int depth, int start, int sum) {
    if (depth == M) {
      if (isPrime(sum)) {
        result.add(sum);
      }
      return;
    }

    // 재귀 시작
    for (int i = start; i < N; i++) {
      findCows(depth + 1, i + 1, sum + cows[i]);
    }
  }

  // 소수 판별 메서드
  static boolean isPrime(int n) {
    if (n < 2) return false;

    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
