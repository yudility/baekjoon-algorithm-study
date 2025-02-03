package BOJ_1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 요세푸스문제_연예림 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n+1; i++ ) {
            queue.offer(i);
        }

        List<Integer> result = new LinkedList<>();

        int i = 1;
        while(!queue.isEmpty()) {
            if (i == k) {
                result.add(queue.poll());
                i = 0;
            } else {
                queue.offer(queue.poll());
            }
            i++;
        }

        String str = result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "<", ">"));
        System.out.println(str);
    }
}
