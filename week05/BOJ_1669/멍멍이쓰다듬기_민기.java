package BOJ_1669;


import java.io.*;
import java.util.StringTokenizer;

public class 멍멍이쓰다듬기_민기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st.nextToken());  // 원숭이 키
		int Y = Integer.parseInt(st.nextToken());  // 멍멍이 키
		int D = Y - X;  // 키 차이

		// 키 차이가 작은 경우(0~3)는 그대로 출력
		// 키 차이가 D일 때, D일 동안 매일 1cm씩 늘리는 방식으로 진행
		if (D <= 3) {
			System.out.println(D);
		} else {
			// 최적의 키 증가 패턴: 1, 2, 3, ..., k, ..., 3, 2, 1
			// D의 제곱근 계산 (최대 증가량 근사치)
			int n = (int)Math.sqrt(D);

			// 케이스 1: D가 n의 제곱과 정확히 일치하는 경우
			// 이 경우 1부터 n-1까지 증가 후 n-1부터 1까지 감소 = 2n-1일
			if (D == n*n) {
				System.out.println(2*n - 1);
			}
			// 케이스 2: D가 n^2보다 크고 n^2+n 이하인 경우
			// 이 경우 1부터 n까지 증가 후 n-1부터 1까지 감소 = 2n일
			else if (D <= n*n + n) {
				System.out.println(2*n);
			}
			// 케이스 3: D가 n^2+n보다 큰 경우
			// 이 경우 1부터 n까지 증가, n일 유지, n-1부터 1까지 감소 = 2n+1일
			else {
				System.out.println(2*n + 1);
			}
		}
	}
}

