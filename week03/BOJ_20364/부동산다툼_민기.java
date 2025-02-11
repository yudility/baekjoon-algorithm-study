package BOJ_20364;

import java.util.*;
import java.io.*;

public class 부동산다툼_민기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		//할당된 땅을 체크하기 위한 배열
		//N+1을 통해 1번 땅은 체크하지 않는다.
		boolean[] isChecked = new boolean[N+1];

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int x = Integer.parseInt(br.readLine());

			// x까지의 경로(조상 경로)를 1번부터 x까지의 순서로 구함.
			// x의 부모 노드는 x/2, 그 다음은 x/4 ... 1까지.
			ArrayList<Integer> path = new ArrayList<>();
			int cur = x;
			while (cur > 1) {   // 1번 땅은 따로 다룸
				path.add(cur);
				cur /= 2;
			}
			// 경로를 거꾸로 뒤집으면 1번 땅 바로 다음부터 x까지의 경로가 됨.
			path.add(1);
			Collections.reverse(path);

			// 1번 땅은 출발지이므로 검사하지 않고, 그 다음부터 검사한다.
			int conflict = 0;
			// path[0]은 항상 1이므로 j=1부터 검사
			for (int j = 1; j < path.size(); j++) {
				int land = path.get(j);
				if (isChecked[land]) {
					conflict = land;
					break;
				}
			}
			if (conflict != 0) {
				// 경로 중 이미 할당된 땅이 있으면 그 번호를 출력
				sb.append(conflict).append("\n");
			} else {
				// 경로에 점유된 땅이 없으면 현재 오리는 원하는 땅 x를 할당받음.
				isChecked[x] = true;
				sb.append(0).append("\n");
			}
		}
		System.out.print(sb);

	}
}
