package BOJ_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무자르기_민기 {

    // 나무들의 높이를 저장할 배열
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //미리 정렬 후 최대값 찾기
        Arrays.sort(arr);

        // 절단기 높이의 최소값 (0m부터 가능)
        int low = 0;
        // 절단기 높이의 최대값 (나무 중 가장 큰 값)
        int high = arr[N-1];

        // 최종적으로 구할 절단기 높이의 최대값
        int result = 0;

        // 이분 탐색 시작
        while (low <= high) {
            // 현재 절단기 높이 mid 계산
            int mid = (low + high) / 2;

            long sum = 0; // 잘라서 얻을 수 있는 총 나무 길이 (long 타입으로 오버플로 방지)

            // 모든 나무를 순회하면서 잘리는 나무 길이 계산
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    // mid보다 나무가 클 때만 잘린다
                    sum += arr[i] - mid;
                }
            }

            // 잘린 나무 길이의 합이 충분한 경우
            if (sum >= M) {
                result = mid;     // 현재 mid 값 저장 (조건을 만족하는 후보)
                low = mid + 1;    // 절단 높이를 더 높여도 되는지 확인하러 오른쪽으로 이동
            } else {
                // 잘린 나무 길이의 합이 부족한 경우
                high = mid - 1;   // 절단 높이를 낮춰야 하므로 왼쪽으로 이동
            }
        }

        // 최종적으로 가능한 절단기 높이의 최대값 출력
        System.out.println(result);
    }
}
