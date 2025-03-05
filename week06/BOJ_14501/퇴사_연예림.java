package BOJ_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_연예림 {
  //15분

  static int[] times;
  static int[] pays;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    times = new int[N+1];
    pays = new int[N+1];

    times[0] = 1;
    pays[0] = 0;

    //입력
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      times[i] = Integer.parseInt(st.nextToken());
      pays[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(calcPay(1,0));

  }

  public static int calcPay(int current, int sumPay) {
    if (N < current) {
      return sumPay;
    }
//    if (N - current + 1 < times[current]) { // 퇴사 전까지 불가능
//      return 0;
//    }

    int maxPay = sumPay;
    int check = 0;
    while (check < times[current] && (current + check) <= N) { // 얘 포함 건너뛰는 것들을 계산해서 max를 계산하는 건데.
        int getPay = calcPay((current + check) + times[current + check],
            sumPay + pays[current + check]); // 넘어갈 일 수, 현재까이의 total 페이
        if (getPay > maxPay) {
          maxPay = getPay;
        }
        check++;
    }

    return maxPay;
  }
}
