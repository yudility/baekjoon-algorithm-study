package BOJ_11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 강의실배정_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 강의 개수

        // 강의 저장하는 배열
        Lecture[] lectures = new Lecture[N];

        // lectures에 강의 저장
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(start, end);
        }

        // 시작 시간 기준으로 오름차순 정렬
        // 시작 시간이 같다면 종료 시간을 기준으로 오름차순 정렬
        Arrays.sort(lectures, (l1, l2) -> l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        // 우선순위 큐에 종료시간만 넣음, 오름차순으로 자동 정렬
        Queue<Integer> q = new PriorityQueue<>();
        q.offer(lectures[0].end);
        
        for (int i = 1; i < N; i++) {
            // 가장 빨리 끝나는 강의의 종료시간과 다음 강의의 시작 시간 비교
            if (q.peek() <= lectures[i].start) {    // 시작 시간이 더 클 경우
                q.poll();   // 강의 종료 == 해당 강의실 사용 가능
            }
            q.offer(lectures[i].end);   // 큐에 해당 강의의 종료시간 넣음
        }

        // 큐의 사이즈가 강의실 최소 개수
        System.out.println(q.size());
    }
}

// 강의 시간 저장 클래스
class Lecture {
    int start;
    int end;

    Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }
}