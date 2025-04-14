package BOJ_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_연예림 {

  static int N;
  static int S;
  static int[] nums;
  static int cnt;
  static int zero_cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // n과 s
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    nums = new int[N];

    // 수열 입력
    st = new StringTokenizer(br.readLine());
    for (int i=0; i < nums.length; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }


    calc_sum(0, 0);
    if (S == 0) {
      System.out.println(cnt-1);
    } else {
      System.out.println(cnt);
    }

  }

  // 현재 값이 목표값과 같으면 cnt++ 하고 리턴
  // 또는 현재 인덱스 값이 마지막이면 그냥 리턴
  private static void calc_sum(int idx, int sum) {
    if (idx == N) {
      if (sum == S) {
        cnt++;
      }
      return;
    }

    calc_sum(idx+1 ,sum); // 안 더하는 경우
    calc_sum(idx+1 , sum + nums[idx]); // 더하는 경우

  }

}
