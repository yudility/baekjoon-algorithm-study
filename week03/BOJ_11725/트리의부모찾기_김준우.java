package BOJ_11725;

import java.util.*;

public class 트리의부모찾기_김준우 {
    // 트리 구현 -> 2차원 배열 사용
    static int n;
    static boolean[] visited;
    static List<Integer> tree[];   
    static int[] answer; // 크기 지정 필요

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n + 1];
        tree = new ArrayList[n + 1];
        answer = new int[n + 1];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            tree[n1].add(n2);
            tree[n2].add(n1);
        }

        DFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }

    static void DFS(int number) {
        visited[number] = true;
        for (Integer i : tree[number]) {
            if (!visited[i]) {
                answer[i] = number;
                DFS(i);
            }
        }
    }
}
