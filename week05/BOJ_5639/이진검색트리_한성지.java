package BOJ_5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이진검색트리_한성지 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전위순회에서 가장 첫번째로 들어온 값이 무조건 root
        Node root = new Node(Integer.parseInt(br.readLine()));
        
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.isBlank()) {
                break;
            }
            // 트리 만듦
            root.insert(Integer.parseInt(input));
        }
        postOrder(root);    // 후위순회
        System.out.println(sb); // 출력
    }

    // 트리 노드 클래스
    static class Node {
        int num;
        Node left;
        Node right;

        Node(int num) {
            this.num = num;
        }

        void insert(int n) {
            if (n < this.num) {     // 현재 노드보다 숫자 작을 경우
                if (this.left == null) {    // 왼쪽 노드 삽입
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {        // 현재 노드보다 숫자 클 경우
                if (this.right == null) {   // 오른쪽 노드 삽입
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }

    // 후위 순회
    static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.num).append("\n");
    }
}
