//package BOJ_1991;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class 트리순회_한성지 {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int n = Integer.parseInt(br.readLine());
//        TreeOrderClass treeOrderClass = new TreeOrderClass();
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            String data = st.nextToken();
//            String leftData = st.nextToken();
//            String rightData = st.nextToken();
//
//            treeOrderClass.createNode(data, leftData, rightData);
//        }
//
//        treeOrderClass.preOrder(treeOrderClass.root);
//        treeOrderClass.sb.append("\n");
//        treeOrderClass.inOrder(treeOrderClass.root);
//        treeOrderClass.sb.append("\n");
//        treeOrderClass.postOrder(treeOrderClass.root);
//
//        System.out.println(treeOrderClass.sb);
//    }
//}
//
//class Node {
//    String data;
//    Node left;
//    Node right;
//
//    Node(String data) {
//        this.data = data;
//    }
//}
//
//class TreeOrderClass {
//    Node root;
//    StringBuilder sb = new StringBuilder();
//
//    public void createNode(String data, String leftData, String rightData) {
//        // 초기 상태
//        if (root == null) {
//            root = new Node(data);
//
//            if (!leftData.equals(".")) {
//                root.left = new Node(leftData);
//            }
//
//            if (!rightData.equals(".")) {
//                root.right = new Node(rightData);
//            }
//        } else {
//            searchNode(root, data, leftData, rightData);
//        }
//    }
//
//    // 매개변수로 들어온 root 노드를 시작으로 data와 같은 값을 가진 node 찾음
//    // 찾을 때까지 root 노드에서 왼쪽, 오른쪽으로 내려감
//    public void searchNode(Node node, String data, String leftData, String rightData) {
//        if (node == null) {     // 도착한 노드가 null이면 재귀 종료
//            return;
//        } else if (node.data.equals(data)) {     // 들어갈 위치 찾은 경우
//            if (!leftData.equals(".")) {    // .(공란)이 아니라 값이 있는 경우에만 노드 생성
//                node.left = new Node(leftData);
//            }
//
//            if (!rightData.equals(".")) {
//                node.right = new Node(rightData);
//            }
//        } else {    // 아직 찾지 못했고, 탐색할 노드가 남아있을 경우
//            searchNode(node.left, data, leftData, rightData);   // 왼쪽 재귀 탐색
//            searchNode(node.right, data, leftData, rightData);  // 오른쪽 재귀 탐색
//        }
//    }
//
//    // 전위순회(root -> left -> right)
//    public void preOrder(Node node) {
//        if (node != null) {
//            sb.append(node.data);
//            if (node.left != null) preOrder(node.left);
//            if (node.right != null) preOrder(node.right);
//        }
//    }
//
//    // 중위순회(left -> root -> right)
//    public void inOrder(Node node) {
//        if (node != null) {
//            if (node.left != null) inOrder(node.left);
//            sb.append(node.data);
//            if (node.right != null) inOrder(node.right);
//        }
//    }
//
//    // 후위순회(left -> right -> root)
//    public void postOrder(Node node) {
//        if (node != null) {
//            if (node.left != null) postOrder(node.left);
//            if (node.right != null) postOrder(node.right);
//            sb.append(node.data);
//        }
//    }
//}