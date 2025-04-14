package BOJ_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합_한성지 {

  static int N;   // 정수 개수
  static int S;   // 수열 원소의 합
  static int[] numbers;   // N개의 정수
  static int answer = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    numbers = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0, 0);

    if (S == 0) {   // 공집합을 제외하기 위해 1 뺌
      System.out.println(answer - 1);
    } else {
      System.out.println(answer);
    }
  }

  // 깊이 우선 탐색
  // 공집합에서 시작해서 하나씩 더해보는 형태
  public static void dfs(int depth, int sum) {
    if (depth == N) {
      if (sum == S) {
        answer++;
      }
      return;
    }

    // 현재 합에 다음 숫자를 더한 경우
    dfs(depth + 1, sum + numbers[depth]);
    
    // 현재 합에 다음 숫자를 더하지 않은 경우
    dfs(depth + 1, sum);
  }
}
