package BOJ_2075;

import java.io.*;
import java.util.*;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
public class N번째큰수_민기 {

    // 두 개의 내림차순으로 정렬된 링크드 리스트를 병합하는 함수
    static Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.value >= l2.value) { // 내림차순이므로 큰 값을 먼저 삽입
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        return dummy.next;
    }

    // 여러 개의 링크드 리스트를 병합하여 하나의 리스트로 만드는 함수
    static Node mergeAllLists(List<Node> lists) {
        while (lists.size() > 1) {
            List<Node> mergedLists = new ArrayList<>();
            for (int i = 0; i < lists.size(); i += 2) {
                if (i + 1 < lists.size()) {
                    mergedLists.add(mergeTwoLists(lists.get(i), lists.get(i + 1)));
                } else {
                    mergedLists.add(lists.get(i));
                }
            }
            lists = mergedLists;
        }
        return lists.get(0);
    }

    public static void main(String[] args) throws IOException {
        // 빠른 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        // N x N 표의 데이터를 저장합니다.
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 열을 밑에서 위로 읽으면서 내림차순 정렬된 링크드 리스트로 변환
        List<Node> lists = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            Node head = null;
            Node tail = null;
            // i를 N-1부터 0까지 감소하면서 읽음 : 가장 큰 값부터 작은 값 순
            for (int i = N - 1; i >= 0; i--) {
                Node newNode = new Node(matrix[i][j]);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }
            lists.add(head);
        }

        // 모든 열의 링크드 리스트를 병합하여 하나의 내림차순 정렬된 리스트로 만듦
        Node merged = mergeAllLists(lists);

        // 병합된 리스트의 첫 번째 노드는 가장 큰 값, 따라서 N번째 큰 값은 N-1번 이동한 노드에 위치
        Node current = merged;
        for (int count = 0; count < N - 1; count++) {
            if (current != null) {
                current = current.next;
            }
        }

        // 결과 출력: N번째 큰 수
        System.out.println(current.value);
    }
}
