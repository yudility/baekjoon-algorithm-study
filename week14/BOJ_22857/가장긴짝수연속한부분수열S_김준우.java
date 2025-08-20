package BOJ_22857;

import java.util.Scanner;

public class 가장긴짝수연속한부분수열S_김준우 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    // left, right을 사용해서 투포인터 알고리즘을 사용합니다.
    int left = 0, right = 0;
    int oddCount = 0;
    int maxLength = 0;

    // 오른쪽 포인터가 N보다 작을 때까지 진행합니다.
    while (right < N) {
      // 만약 오른쪽 포인터가 가리키는 배열의 값이 홀수라면 oddCount를 증가시킵니다.
      if (arr[right] % 2 != 0) {
        oddCount++;
      }

      // oddCount가 K개를 넘어가면 이제 왼쪽 포인터를 홀수의 개수가 K개 이내가 될 때까지 이동시킵니다.
      while (oddCount > K) {
        if (arr[left] % 2 != 0) {
          oddCount--;
        }
        left++;
      }

      // 연속하는 짝수의 최대 개수는 전체 길이 - 홀수 개수입니다.
      maxLength = Math.max(maxLength, right - left + 1 - oddCount);

      right++;
    }

    System.out.println(maxLength);
  }
}
