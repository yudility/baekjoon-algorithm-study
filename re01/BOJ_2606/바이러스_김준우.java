package BOJ_2606;

import java.util.*;
import java.lang.*;
import java.io.*;

public class 바이러스_김준우 {
    public static List<Integer>[] computers;
    public static boolean[] visited;
    public static Stack<Integer> stack = new Stack<>();
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());

        computers = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        // 인접 리스트를 이용해 노드 연결
        for(int i = 1; i <= N; i++) {
            computers[i] = new ArrayList<>();
        }

        // 컴퓨터 연결 정보 입력
        for(int i = 0; i < pair; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            computers[x].add(y);
            computers[y].add(x);
        }

        int result = bfs(1);
        System.out.println(result);

    }

    // 스택을 이용한 BFS
    public static int bfs(int start) {
        stack.push(start);
        visited[start] = true;

        while(!stack.isEmpty()) {
            int current = stack.pop();

            for(int next : computers[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    stack.push(next);
                }
            }
        }

        return count;

    }
}
