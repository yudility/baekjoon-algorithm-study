package BOJ_6443;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 애너그램_민기 {

	// 현재까지 만든 결과 순열을 저장할 배열
	static char[] result;

	// 해당 문자가 이미 사용되었는지 체크하기 위한 방문 배열
	static boolean[] visited;

	// 최종 출력 결과를 모아둘 StringBuilder
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스 개수 입력
		int n = Integer.parseInt(br.readLine());

		// 각 테스트 케이스마다 순열 탐색 수행
		for (int i = 0; i < n; i++) {
			String word = br.readLine();        // 입력 문자열
			char[] chars = word.toCharArray();  // 문자 배열로 변환
			Arrays.sort(chars);                // 사전 순 출력을 위해 정렬

			int length = chars.length;
			result = new char[length];         // 현재까지 만든 문자열 저장용 배열
			visited = new boolean[length];     // 각 문자가 사용되었는지 체크하는 배열

			// 백트래킹 시작
			backtracking(chars, 0);
		}

		// 결과 한 번에 출력
		System.out.print(sb);
	}

	// 백트래킹 함수: depth는 현재 result에 채워진 문자의 수
	static void backtracking(char[] chars, int depth) {
		// 모든 문자를 다 사용해 하나의 순열이 완성되었을 경우
		if (depth == chars.length) {
			sb.append(new String(result)).append('\n');  // 결과 저장
			return;
		}

		// 현재 깊이에서 이전에 사용한 문자 기록용 변수
		// 같은 문자로 시작하는 중복 순열 방지를 위해 사용
		char prev = 0;

		for (int i = 0; i < chars.length; i++) {
			// 1. 이미 방문한 문자이면 패스
			// 2. 같은 레벨에서 이전에 사용한 문자(prev)와 같으면 중복이므로 패스
			if (visited[i] || prev == chars[i]) {
				continue;
			}

			// 현재 문자를 사용 처리
			visited[i] = true;
			result[depth] = chars[i];
			prev = chars[i]; // 중복 체크용 prev 값 갱신

			// 다음 문자로 이동 (깊이 증가)
			backtracking(chars, depth + 1);

			// 백트래킹 - 원상 복구
			visited[i] = false;
		}
	}
}