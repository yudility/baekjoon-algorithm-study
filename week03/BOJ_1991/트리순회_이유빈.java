package BOJ_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리순회_이유빈 {
    static Map<String, List<String>> tree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new HashMap<>();
        sb = new StringBuilder();

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            tree.put(parent, new ArrayList<>(Arrays.asList(left, right)));
        }

        preOrder("A");
        sb.append("\n");
        inOrder("A");
        sb.append("\n");
        postOrder("A");
        System.out.println(sb);
    }

    static void preOrder(String node) {
        String left = tree.get(node).get(0);
        String right = tree.get(node).get(1);

        sb.append(node);
        if (!left.equals(".")) preOrder(left);
        if (!right.equals(".")) preOrder(right);
    }

    static void inOrder(String node) {
        String left = tree.get(node).get(0);
        String right = tree.get(node).get(1);

        if (!left.equals(".")) inOrder(left);
        sb.append(node);
        if (!right.equals(".")) inOrder(right);
    }

    static void postOrder(String node) {
        String left = tree.get(node).get(0);
        String right = tree.get(node).get(1);

        if (!left.equals(".")) postOrder(left);
        if (!right.equals(".")) postOrder(right);
        sb.append(node);
    }
}
