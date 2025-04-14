package BOJ_2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Java 15로 풀 수 없는 문제 - 메모리 초과 해결 안됨
public class N번째큰수_한성지 {
    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());    // n개의 줄에 각각 n개의 수 주어짐
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());    // 최대힙
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());    // 각 줄 숫자 받아옴

            for (int j = 0; j < n; j++) {
                // 각 숫자 받아서 최대힙에 넣음
                int num = Integer.parseInt(st.nextToken());
                maxHeap.offer(num);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            // n-1번째 숫자까지 제거
            maxHeap.poll();
        }
        // n-1번째 숫자까지 제거 -> 현재 root는 n번째로 큰 수
        
        // 출력
        System.out.println(maxHeap.poll());
    }
}