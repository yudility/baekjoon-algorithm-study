package BOJ_9934;

import java.util.*;
import java.io.*;


public class 완전이진트리_민기 {
	static List<List<Integer>> levels; // 각 레벨별 노드를 저장할 리스트
	static int[] arr; // 중위 순회 결과 (입력 데이터)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine()); // 트리의 깊이
		int num = (1 << k) - 1; // 노드 개수: 2^K - 1
		arr = new int[num]; // 배열 생성
		levels = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// K개의 레벨 리스트 초기화
		for (int i = 0; i < k; i++) {
			levels.add(new ArrayList<>());
		}

		// 재귀적으로 트리 구성
		buildTree(0, num - 1, 0);

		// 결과 출력
		for (List<Integer> level : levels) {
			for (int val : level) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	// 중위 순회 결과를 기반으로 트리를 재귀적으로 구성
	static void buildTree(int left, int right, int depth) {
		if (left > right) return;
		int mid = (left + right) / 2; // 중간값이 루트 노드

		levels.get(depth).add(arr[mid]); // 현재 깊이에 해당하는 리스트에 추가

		buildTree(left, mid - 1, depth + 1); // 왼쪽 서브트리
		buildTree(mid + 1, right, depth + 1); // 오른쪽 서브트리
	}
}
