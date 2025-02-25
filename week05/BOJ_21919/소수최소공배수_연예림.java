package BOJ_21919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수최소공배수_연예림 {
  static boolean[] isSosu;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] nums = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    int max = 0;
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
      max = Math.max(nums[i], max);
    }

    sosuCalc(max); // 소수

    long result = 1;
    for (int n : nums) {
      if (!isSosu[n]) {
        result *= n;
        isSosu[n] = true; // 같은 수가 곱해지지 않도록
      }
    }

    if (result == 1) {
      System.out.println(-1);
    } else {
      System.out.println(result);
    }

  }


  // 소수 판별
  public static void sosuCalc(int max) {
    isSosu =  new boolean[max + 1];

    isSosu[0] = true;
    isSosu[1] = true;

    for (int i = 2; i < isSosu.length; i++) {
      for (int j = i + i; j < isSosu.length; j += i) {
        if (!isSosu[j]) {
          isSosu[j] = true;
        }
      }
    }
  }
}
