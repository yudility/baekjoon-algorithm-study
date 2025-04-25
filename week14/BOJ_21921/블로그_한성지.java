package BOJ_21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블로그_한성지 {

  static int N;   // 블로그 개설 일수
  static int X;   // 기간
  static int[] visitorCounts;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    visitorCounts = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      visitorCounts[i] = Integer.parseInt(st.nextToken());
    }

    // 초기 sum값 세팅 (0~(X-1)번째 구간까지 더한 값)
    int sum = 0;
    for (int i = 0; i < X; i++) {
      sum += visitorCounts[i];
    }

    // 초기 max, count값 세팅
    int max = sum;
    int count = 1;

    // 초기 값을 더한 다음 구간 계산
    for (int i = X; i < N; i++) {
      sum = sum - visitorCounts[i-X] + visitorCounts[i];  // 현재 합에서 구간을 벗어난 이전 값 빼고 다음 값 더함

      if (max < sum) {
        max = sum;   
        count = 1;
      } else if (max == sum) {
        count ++;
      }

    }

    if (max == 0) {   // 방문객이 없을 경우 SAD 출력
      System.out.println("SAD");
    } else {    // 방문객 있을 경우 max값과 max값 나오는 구간 개수 출력
      System.out.println(max + "\n" + count);
    }
  }
}