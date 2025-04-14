package BOJ_16937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두스티커_민기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 모눈종이 크기 입력
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		// 스티커 개수 입력
		int n = Integer.parseInt(br.readLine());
		int[][] sticker = new int[n][2];

		// 각 스티커의 크기 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			sticker[i][0] = r;
			sticker[i][1] = c;
		}

		int maxArea = 0; // 최대 스티커 면적 저장 변수

		// 두 개의 스티커를 선택하는 모든 경우 탐색
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int r1 = sticker[i][0], c1 = sticker[i][1]; // 첫 번째 스티커 크기
				int r2 = sticker[j][0], c2 = sticker[j][1]; // 두 번째 스티커 크기

				// 1️⃣ 두 스티커를 가로로 붙이는 경우 (세로는 최대값)
				if (r1 + r2 <= w && Math.max(c1, c2) <= h) {
					maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
				}

				// 2️⃣ 두 스티커를 세로로 붙이는 경우 (가로는 최대값)
				if (c1 + c2 <= w && Math.max(r1, r2) <= h) {
					maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
				}

				// 3️⃣ 스티커 하나를 90도 회전하여 배치하는 경우
				// 첫 번째 스티커는 그대로, 두 번째 스티커를 90도 회전
				if (c1 + r2 <= w && Math.max(c2, r1) <= h) {
					maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
				}
				if (c2 + r1 <= w && Math.max(c1, r2) <= h) {
					maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
				}

				// 4️⃣ 두 스티커를 세로로 붙이는 경우 (반대 방향)
				if (r1 + r2 <= h && Math.max(c1, c2) <= w) {
					maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
				}

				// 5️⃣ 두 스티커를 가로로 붙이는 경우 (반대 방향)
				if (c1 + c2 <= h && Math.max(r1, r2) <= w) {
					maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
				}

				// 6️⃣ 또 다른 90도 회전 조합 고려
				if (c1 + r2 <= h && Math.max(c2, r1) <= w) {
					maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
				}
				if (c2 + r1 <= h && Math.max(c1, r2) <= w) {
					maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
				}
			}
		}

		// 최댓값 출력
		System.out.println(maxArea);
	}
}