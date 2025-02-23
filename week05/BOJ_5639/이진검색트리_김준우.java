package BOJ_5639;

import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

public class 이진검색트리_김준우 {
    static int current = 0;

    public static Node buildTree(int[] preOrder, int start, int end) {
        if (start > end) {
            return null;
        }

        Node node = new Node(preOrder[current]);
        current++;

        if (start == end) {
            return node;
        }

        int index = start;
        while (index <= end && preOrder[index] < node.data) {
            index++;
        }

        node.left = buildTree(preOrder, start + 1, index - 1);
        node.right = buildTree(preOrder, index, end);

        return node;
    }

    public static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 전위순회한 결과가 한 줄씩 주어지므로, 입력이 끝날 때까지 읽어들임
        int[] preOrder = new int[10000]; // 충분히 큰 크기 설정
        int idx = 0;

        while (sc.hasNext()) {
            preOrder[idx++] = sc.nextInt();
        }

        // 전위 순회 배열 길이
        int n = idx;

        Node root = buildTree(preOrder, 0, n - 1);
        postOrder(root);
    }
}
