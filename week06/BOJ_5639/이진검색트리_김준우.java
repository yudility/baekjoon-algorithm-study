package BOJ_5639;

import java.util.ArrayList;
import java.util.List;
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
    static int index = 0; // preorder 원소 값을 가져오기 위해서 사용
    public static Node buildTree(List<Integer> preorder, int maxValue) {
        if (index >= preorder.size() || preorder.get(index) > maxValue) {
            return null;
        }

        Node root = new Node(preorder.get(index++));

        // 왼쪽 서브트리 생성 (현재 노드보다 작은 값들만 가능)
        root.left = buildTree(preorder, root.data);

        // 오른쪽 서브트리 생성 (현재 노드보다 큰 값들만 가능)
        root.right = buildTree(preorder, maxValue);

        return root;
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> preOrder = new ArrayList<>();
        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            }
            preOrder.add(Integer.parseInt(input));
        }

        Node root = buildTree(preOrder, Integer.MAX_VALUE);
        postOrder(root);
    }
}

