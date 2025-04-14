package BOJ_19699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 소난다_한성지 {

  static int N;   // 소의 수
  static int M;   // 선별할 소의 수
  static int[] H; // 소들의 몸무게
  static Set<Integer> answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    H = new int[N];
    answer = new HashSet<>();

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      H[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0, 0, 0);

    if (!answer.isEmpty()) {
      List<Integer> answerList = new ArrayList<>(answer);
      Collections.sort(answerList);
      for (int num : answerList) {
        System.out.print(num + " ");
      }
    } else {
      System.out.println(-1);
    }
  }

  public static void dfs(int depth, int sum, int idx) {
    if (depth == N) {
      if (idx == M && isPrime(sum)) {
        answer.add(sum);
      }
      return;
    }
    
    dfs(depth + 1, sum + H[depth], idx + 1);
    dfs(depth + 1, sum, idx);
  }
  
  // 소수 판별
  public static boolean isPrime(int num) {

    // num이 1 이하인 경우 소수일 수 없으므로 false 반환
    if (num < 2) {
      return false;
    }

    // num이 2인 경우 소수이므로 true 반환
    if (num == 2) { 
      return true;
    }
    
    // 짝수인 경우 false 반환
    if (num % 2 == 0) {
      return false;
    }

    int sqrt = (int) Math.sqrt(num);  // num의 제곱근
    for (int i = 3; i <= sqrt; i += 2) {  // 홀수 중 3~제곱근까지의 수로 나눠떨어지는 경우 false 반환
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }
}