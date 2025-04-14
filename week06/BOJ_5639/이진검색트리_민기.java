package BOJ_5639;

import java.util.*;
import java.io.*;

public class 이진검색트리_민기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> preorder = new ArrayList<>();

		String line;
		// EOF까지 입력 받기
		// 입력의 끝을 알 수 없으므로 null이나 빈 문자열이 나올 때까지 계속 읽음
		while ((line = br.readLine()) != null && !line.isEmpty()) {
			preorder.add(Integer.parseInt(line));
		}

		// 전위 순회 결과로 후위 순회 결과 계산
		postorder(preorder, 0, preorder.size() - 1);
	}

	// postorder 메소드는 위와 동일
	public static void postorder(List<Integer> preorder, int start, int end) {
		if (start > end) return;

		// 현재 서브트리의 루트 노드 값
		int root = preorder.get(start);
		int idx = start + 1;

		// 이진 검색 트리의 특성을 이용해 오른쪽 서브트리의 시작점 찾기
		// 루트보다 큰 값이 나오는 지점이 오른쪽 서브트리의 시작점
		while (idx <= end && preorder.get(idx) < root) {
			idx++;
		}

		// 후위 순회: 왼쪽 서브트리 -> 오른쪽 서브트리 -> 루트
		// 1. 왼쪽 서브트리 후위 순회 (start+1 ~ idx-1)
		postorder(preorder, start + 1, idx - 1);

		// 2. 오른쪽 서브트리 후위 순회 (idx ~ end)
		postorder(preorder, idx, end);
		// 3. 루트 노드 출력
		System.out.println(root);
	}
}

