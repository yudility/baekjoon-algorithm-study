package BOJ_20438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// 26분
public class 출석체크_연예림 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(st.nextToken()); // 총학생수
    int K = Integer.parseInt(st.nextToken()); // 조는애들
    int Q = Integer.parseInt(st.nextToken()); // 출석코드 받는 애들 수
    int M = Integer.parseInt(st.nextToken()); // 구간 수

    // 조는 학생들
    Set<Integer> kk = new HashSet<>();
    
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= K; i++) {
      kk.add(Integer.parseInt(st.nextToken()));
    }

    // 출석 코드를 받은 학생들
    List<Integer> qq = new ArrayList<>(); // 출석 코드 전달이 가능한 학생들

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= Q; i++) {
      int input = Integer.parseInt(st.nextToken());
      if (!kk.contains(input)) { // 조는 학생을 제외하고 추가
        qq.add(input);
      }
    }

    // 구간 합 구하기
    int[] check = new int[N+3]; // 이전까지의 출석 안된 학생 수
    for (int i = 3; i < check.length; i++) {
      boolean flag = false;    // 출석 체크 여부
      for (int num : qq) {
        if (i % num == 0 && !kk.contains(i)) { // 배수이고 조는 학생이 아닐때
          flag = true;
          check[i] = check[i-1]; // 이전까지의 합산 그대로 기록
          break;
        }
      }
      if (!flag) {
        check[i] += check[i-1] + 1;
      }
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      sb.append(check[b] - check[a-1]).append("\n");
    }
    System.out.println(sb);
  }
}
