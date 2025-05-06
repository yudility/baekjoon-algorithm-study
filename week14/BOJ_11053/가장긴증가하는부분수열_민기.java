package BOJ_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열_민기 {

	static int[] dp;   // dp[i] : i번째 원소를 마지막으로 하는 LIS의 길이
	static int[] arr;  // 입력 수열 저장
	static int N;      // 수열의 길이

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 수열 길이 입력

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N]; // 수열 배열 초기화
		dp = new int[N];  // dp 배열 초기화 (0이면 아직 계산 안 된 상태)

		// 수열 입력받기
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0; // 가장 긴 증가 수열의 길이 저장 변수

		// 각 위치를 끝으로 하는 LIS 길이를 구해서 최댓값 갱신
		for (int i = 0; i < N; i++) {
			max = Math.max(max, top(i));
		}

		System.out.println(max); // 결과 출력
	}

	// Top-Down 방식으로 i번째 원소를 마지막으로 하는 LIS 길이를 반환
	static int top(int N) {
		// 이미 계산된 경우는 그대로 반환
		if (dp[N] != 0) return dp[N];

		dp[N] = 1; // 자기 자신만 있는 수열도 길이는 1

		// 현재 인덱스 N보다 앞쪽에 있는 모든 인덱스를 탐색
		for (int i = 0; i < N; i++) {
			// arr[i] < arr[N] → 증가 수열 조건 만족 시
			if (arr[i] < arr[N]) {
				// i까지의 LIS에 현재 N번째 원소를 추가했을 때 더 긴 경우 갱신
				dp[N] = Math.max(dp[N], top(i) + 1);
			}
		}

		return dp[N]; // N을 끝으로 하는 LIS 길이 반환
	}
}