package BOJ_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 부분수열의합_민기 {
	static int[] arr;
	static int count =0;
	static int N,S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		// 수열 받기
		st = new StringTokenizer(br.readLine());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		comb(0, 0);

		// S가 0인 경우, 빈 부분수열을 제외
		if (S == 0) {
			count--;
		}

		System.out.println(count);
	}

	static void comb(int idx, int sum) {

		// 모든 원소를 탐색한 경우
		if (idx == N) {
			// 합이 S인 경우
			if (sum == S) {
				count++;
			}
			return;
		}


		//idx부터 N까지 반복하며 sum을 계속 더함 인줄 알았으나 포함하지 않는 경우도 생각
		comb(idx + 1, sum + arr[idx]);  // 현재 원소를 포함하는 경우
		comb(idx + 1, sum);             // 현재 원소를 포함하지 않는 경우
	}
}
