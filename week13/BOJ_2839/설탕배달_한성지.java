package BOJ_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2839
public class 설탕배달_한성지 {

  static int N; // 설탕 무게
  static int five, three; // 5, 3킬로 각각 봉지 개수
  static int answer;  // 최소 봉지 개수

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    five = N / 5;
    solution(five);

    // 3킬로 봉지만 썼을 때 개수가 더 적을 수 있으므로 검사
    if (N % 3 == 0 && answer > N / 3) {
      answer = N / 3;
    }

    System.out.println(answer);
  }

  // 그리디 + 재귀
  static void solution(int f) {

    // f가 음수가 되는 경우 정확하게 N 킬로그램을 만들 수 없는 것이므로 -1
    if (f < 0) {
      answer = -1;
      return;
    }

    int remain = N - (5 * f); // N에서 현재 5킬로 봉지 개수만큼 무게를 뺀 값

    // remain에서 3으로 나눠떨어지는 경우 5, 3 봉지 함께 쓸 때 최소값이므로 answer에 값 저장
    if (remain % 3 == 0) {
      three = remain / 3;
      answer = f + three;
    } else {  // 나눠떨어지지 않는 경우 재귀
      solution(f - 1);
    }
  }
}