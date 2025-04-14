package BOJ_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 트리순회_박유진 {

    static class Node{
        String ch;
        Node leftChild;
        Node rightChild;

        Node(String ch){
            this.ch = ch;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Map<String, Node> tree = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken(); // 부모
            String lc = st.nextToken();// 왼쪽 자식
            String rc = st.nextToken(); // 오른쪽 자식

            tree.putIfAbsent(c, new Node(c));

            if(!lc.equals(".")){
                tree.put(lc, new Node(lc));
                tree.get(c).leftChild = tree.get(lc);
            }
            if(!rc.equals(".")){
                tree.putIfAbsent(rc, new Node(rc));
                tree.get(c).rightChild = tree.get(rc);
            }
        }
        Node r = tree.get("A");

        printPreOrder(sb, tree, r);
        sb.append("\n");
        printInOrder(sb, tree, r);
        sb.append("\n");
        printPostOrder(sb, tree, r);

        System.out.println(sb);
    }
    private static void printPreOrder(StringBuilder sb, Map<String, Node> tree, Node now) {
        if(now == null) return;

        sb.append(now.ch);
        if(now.leftChild != null) printPreOrder(sb, tree, now.leftChild);
        if(now.rightChild != null) printPreOrder(sb, tree, now.rightChild);
    }

    private static void printInOrder(StringBuilder sb, Map<String, Node> tree, Node now) {
        if(now == null) return;

        printInOrder(sb, tree, now.leftChild);
        sb.append(now.ch);
        printInOrder(sb, tree, now.rightChild);
    }

    private static void printPostOrder(StringBuilder sb, Map<String, Node> tree, Node now) {
        if(now == null) return;
        if(now.leftChild != null) printPostOrder(sb, tree, now.leftChild);
        if(now.rightChild != null) printPostOrder(sb, tree, now.rightChild);
        sb.append(now.ch);
    }

//    처음 인덱스로 시도했던 코드
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//
//        //tree
//        String[] tree = new String[52];
//        for(int i= 0; i<52; i++) {
//            tree[i] = ".";
//        }
//
//        tree[0] = "A"; // 루트 설정
//
//
//        int n = Integer.parseInt(br.readLine());
//
//        // 입력에 맞게 노드 삽입
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            String c = st.nextToken(); // 부모
//            String lc = st.nextToken();// 왼쪽 자식
//            String rc = st.nextToken(); // 오른쪽 자식
//
//            // 입력값이 1<= n <= 26 이므로, 노드의 개수는 최대 26개
//            // 따라서 시간복잡도 상으로 무리가 없다고 판단하여 for문으로 각 노드 탐색
//            for (int j = 0; j < 52; j++) {
//                if (tree[j].equals(c)) { //이미 삽입한 적이 있다면
//                    tree[j * 2 + 1] = lc; //왼쪽 자식 등록
//                    tree[j * 2 + 2] = rc; //오른쪽 자식 등록
//                    break;
//                }
//            }
//        }
//        printPreOrder(sb, tree, 0);
//        sb.append("\n");
//        printInOrder(sb, tree, 0);
//        sb.append("\n");
//        printPostOrder(sb, tree, 0);
//
//        System.out.println(sb);
//    }
//
//    public static void printPreOrder(StringBuilder sb, String[] tree, int idx) {
//        if (idx >= tree.length || tree[idx].equals(".")) {
//            return;
//        }
//        //전위 순회: 루트 -> 왼쪽 -> 오른쪽
//        sb.append(tree[idx]);
//        printPreOrder(sb, tree, idx * 2 + 1); //왼쪽 자식으로 이동
//        printPreOrder(sb, tree, idx * 2 + 2); //오른쪽 자식으로 이동
//
//    }
//
//    public static void printInOrder(StringBuilder sb, String[] tree, int idx) {
//        if (idx >= tree.length  || tree[idx].equals(".")) {
//            return;
//        }
//        //중위 순회: 왼쪽 -> 루트 -> 오른쪽
//        printInOrder(sb, tree, idx * 2 + 1);
//        sb.append(tree[idx]);
//        printInOrder(sb, tree, idx * 2 + 2);
//    }
//
//    public static void printPostOrder(StringBuilder sb, String[] tree, int idx) {
//        if (idx >= tree.length || tree[idx].equals(".")) {
//            return;
//        }
//        // 후위 순회: 왼쪽 -> 오른쪽 -> 루트
//        printPostOrder(sb, tree, idx * 2 + 1); //왼쪽 자식 먼저 이동
//        printPostOrder(sb, tree, idx * 2 + 2); //
//        sb.append(tree[idx]);
//    }
}
