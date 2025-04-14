package BOJ_1991;

import java.util.Scanner;

public class 트리순회_김준우 {
    static class Node {
        String data;
        Node left, right;

        public Node(String data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static Node root;

    public static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            String parent = sc.next();
            String left = sc.next();
            String right = sc.next();

            if (root == null) {
                root = new Node(parent);
            }

            Node pNode = findNode(root, parent);
            if (pNode == null) {
                pNode = new Node(parent);
            }

            if (!left.equals(".")) {
                pNode.left = new Node(left);
            }

            if (!right.equals(".")) {
                pNode.right = new Node(right);
            }
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    // 노드 간 연결을 위해 노드를 탐색하는 코드
    public static Node findNode(Node node, String data) {
        if (node == null) return null;
        if (node.data.equals(data)) return node;

        Node leftSearch = findNode(node.left, data);
        if (leftSearch != null) return leftSearch;

        return findNode(node.right, data);
    }
}