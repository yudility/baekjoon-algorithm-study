package BOJ_11000;

import java.util.*;
import java.io.*;

public class 강의실배정_민기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());


		// 각 강의를 [시작시간, 종료시간] 형태로 저장
		int[][] lectures = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lectures[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
			lectures[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
		}

		//시작 시간 기준으로 강의 정렬
		Arrays.sort(lectures, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});

		//priorityQueue로 종료 시간 관리
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		//첫번재 시간 넣기
		pq.offer(lectures[0][1]);

		for (int i = 1; i < N; i++) {

			//현재 강의의 S(시작 시간)이 가장 빨리 끝나는 종료 시간보다 크거나 같으면
			//해당 강의실은 연강이 가능하기때문에 큐에서 제거
			if (pq.peek() <= lectures[i][0]) {
				pq.poll();
			}

			//현재 강의의 종료 시간을 큐에 추가 ( 새로운 강의실로 할당)
			pq.offer(lectures[i][1]);
		}

		System.out.println(pq.size());
	}
}
