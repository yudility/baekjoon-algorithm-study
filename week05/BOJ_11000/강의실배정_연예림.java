package BOJ_11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//5시
public class 강의실배정_연예림 {
    public static void main(String[] args) throws IOException {
        // 시작 시간과 종료 시간이 동일한 강의실을 연결하자.
        // 강의실 수 만큼 ArrayList 생성한다.
        // 처음 강의실이 들어오면 ArrayList를 생성 -> deque를 생성? (3, 5)
        // 시작 시간을 기준으로 정렬, 종료-시작 시간을 기준으로 정렬?
        // 만약 (1, 3)을 보고
        // 모든 덱의 첫번째 강의의 시작시간과 3을 비교
        // 모든 덱의 마지막 강의의 종료시간과 1(시작시간)이 같다면 해당 덱에 추가
        // => 강의시간이 짧은 코드를 넣는게 더 좋을 수도 있음. (?)
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 우선순위 설정
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> {
            if(o1[0] == o2[0]){ // 시작시간이 같으면 도착시간이 빠른 순으로
                return o1[1] - o2[1];
            }else{
                return o1[0] - o2[0];
            }
        }));


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{start, end});
        }

        // 종료시간을 담을 큐
        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.offer(0);

        // room 에서 하니씩 값을 peek하고, 시간을 비교하고 poll을 한다.
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(room.peek() <= cur[0]){
                room.poll();
            }
            room.offer(cur[1]);
        }

        System.out.println(room.size());
    }
}
