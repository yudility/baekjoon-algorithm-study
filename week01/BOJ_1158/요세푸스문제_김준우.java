package BOJ_1158;

import java.io.*;
import java.util.*;

public class 요세푸스문제_김준우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        // 입력 처리
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 큐에 값 추가 (1부터 n까지)
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // 요세푸스 순열 계산
        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll()); // k-1번 맨 앞의 값을 뒤로 보냄
            }
            list.add(queue.poll()); // k번째 값을 리스트에 추가
        }

        // 결과 출력
        bw.write("<");
        for (int i = 0; i < list.size(); i++) {
            bw.write(String.valueOf(list.get(i)));
            if (i < list.size() - 1) {
                bw.write(", ");
            }
        }
        bw.write(">");

        br.close();
        bw.close();
    }
}
