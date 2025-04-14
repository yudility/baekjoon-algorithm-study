package BOJ_11725;

import java.io.*;
import java.util.*;

public class 트리의부모찾기_민기 {
	static List<Integer>[] tree;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		//배열의 0번을 사용하지 않기 위해 N+1로 선언
		tree = new ArrayList[N + 1];
		parent = new int[N + 1];

		// 인접 리스트 초기화
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}

		// 양방향 간선 정보 입력
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree[u].add(v);
			tree[v].add(u);
		}

		// DFS를 통해 1번 노드에서부터 부모 노드를 결정, 시작 노드의 부모는 0(또는 -1)으로 지정
		dfs(1, 0);

		// 결과 출력 (2번 노드부터)
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 2; i <= N; i++) {
			bw.write(parent[i] + "\n");
		}
		bw.flush();
		bw.close();

	}
	// DFS 재귀 함수: 현재 노드와 부모 노드를 파라미터로 받음
	static void dfs(int node, int par) {
		// 현재 노드의 부모 할당
		parent[node] = par;
		// if문을 통해 현재 노드에서 부모 노드로 돌아가는 것을 방지,
		List<Integer> currentList = tree[node]; // 현재 노드의 모든 인접 노드를 가져옴
		for (int i = 0; i < currentList.size(); i++) {
			int next = currentList.get(i);      // 현재 인덱스 i에 해당하는 인접 노드
			if (next == par) {                  // 만약 이 노드가 부모와 같다면
				// 부모 노드는 이미 방문한 노드이므로 재귀 호출하지 않고 건너뜁니다.
				continue;
			} else {
				// 부모가 아니라면, 현재 노드를 next의 부모로 지정한 후, dfs를 재귀적으로 호출합니다.
				dfs(next, node);
			}
		}
	}
}
