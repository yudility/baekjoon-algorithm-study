package BOJ_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 트리순회_연예림 {
    static boolean[] visited;
    static HashMap<String, List<String>> graph;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        graph = new HashMap<>();

        // 입력 : 그래프 HashMap (key, [left, right])
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            graph.put(s[0], new ArrayList<>(Arrays.asList(s[1], s[2])));
        }

        preorder("A");
        sb.append("\n");
        inorder("A");
        sb.append("\n");
        postorder("A");

        System.out.println(sb);
    }

    static void preorder(String node) {
        String left = graph.get(node).get(0);
        String right = graph.get(node).get(1);

        sb.append(node);
        if (!left.equals(".")) { preorder(left); }
        if (!right.equals(".")) { preorder(right); }
    }

    static void inorder(String node) {
        String left = graph.get(node).get(0);
        String right = graph.get(node).get(1);

        if (!left.equals(".")) { inorder(left); }
        sb.append(node);
        if (!right.equals(".")) { inorder(right); }
    }

    static void postorder(String node) {
        String left = graph.get(node).get(0);
        String right = graph.get(node).get(1);

        if (!left.equals(".")) { postorder(left); }
        if (!right.equals(".")) { postorder(right); }
        sb.append(node);
    }
}
