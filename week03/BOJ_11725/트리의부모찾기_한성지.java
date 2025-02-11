package BOJ_11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기_한성지 {

    static int n;                   // 노드 개수
    static boolean[] visited;       // 각 노드 방문 여부 확인
    static List<Integer>[] list;    // 노드 저장
    static int[] parent;            // 부모 노드 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {       // 연결된 노드값 입력 받음
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // list에 모든 노드들의 바로 위아래 연결상태 저장
            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        // 배열 출력
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    // 너비 우선 탐색
    public static void dfs(int index) {
        visited[index] = true;      // 방문 시 true로 변경
        for (int i : list[index]) { // list에 저장된 노드 번호 중 가장 처음 나오는 방문하지 않았던 노드가 해당 노드의 부모
            if (!visited[i]) {      
                parent[i] = index;
                dfs(i);    // 부모 노드 저장 후 다음 노드 탐색
            }
        }
    }
}