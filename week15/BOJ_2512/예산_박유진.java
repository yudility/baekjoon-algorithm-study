package BOJ_2512;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 예산_박유진 {
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      //첫 번째 입력 줄을 공백으로 분리하고, 첫 번째 토큰을 정수로 변환하여 지방의 수 N을 저장
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int N = Integer.parseInt(st.nextToken()); // 지방의 수

      //각 지방의 예산 요청을 저장할 배열을 생성하고, 두 번째 줄의 입력 받기
      int[] arr = new int[N];
      st = new StringTokenizer(br.readLine(), " "); // 각 지방의 예산요청

      //이분탐색의 범위를 설정
      int left = 0;
      int right = -1; // 예산의 최대 금액

      //반복문으로 각 지방의 예산 요청을 배열에 저장하고, 동시에 최대 예산 요청을 찾는다.
      for (int i = 0; i < N; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
        right = Math.max(right, arr[i]);
      }

      int M = Integer.parseInt(br.readLine()); // 총 예산


      //이분탐색 시작
      while (left <= right) {
        //left와 right 사이의 중간값 mid를 계산
        int mid = (left + right) / 2;

        //현재 상한액(mid)으로 모든 지방에 예산을 분배했을 때의 총 합을 계산
        long budget = 0;
        for (int i = 0; i < N; i++) {
          //각 지방은 요청한 금액과 상한액 중 작은 값을 받음
          //이 값들의 합을 budget에 저장
          budget += Math.min(arr[i], mid);
        }

        //계산된 총 예산이 총 예산 한도 M보다 작거나 같으면,
        if (budget <= M) {
          left = mid + 1; //상한액을 높일 수 있으므로 left를 증가
        } else {
          right = mid -1; //그렇지 않으면 상한액을 낮춰야 하므로 right를 감소
        }
      }
      System.out.println(right); //이분탐색이 종료된 후, right 값이 조건을 만족하는 최대 상한액
    }
  }