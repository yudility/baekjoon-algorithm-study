package BOJ_9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 완전이진트리_한성지 {

    static int K, size;     // 트리 높이, 노드 개수
    static int[] num;       // 빌딩 번호
    static List<List<Integer>> tree;    // 트리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        size = (int) (Math.pow(2, K) - 1);
        tree = new ArrayList<>();
        num = new int[size+1];

        // 트리 각 계층 arrayList 만들기
        for (int i = 0; i <= K; i++) {
            tree.add(new ArrayList<>());
        }

        int index = 1;
        while (st.hasMoreTokens()) {
            num[index++] = Integer.parseInt(st.nextToken());
        }

        search(1, 1, size);

        // 각 층 빌딩 정보 StringBuilder에 저장
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < tree.get(i).size(); j++) {
                sb.append(tree.get(i).get(j)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    // 중위 순회 특성을 이용한 레벨에 맞는 빌딩 값들 저장 메서드
    static void search(int depth, int start, int end) {
        int mid = (start + end) / 2;    // root 노드
        tree.get(depth).add(num[mid]);  // 가장 첫 줄에 root 노드 저장
        if (depth == K) {       // 단말 노드일 경우
            return;
        }
        search(depth + 1, start, mid - 1);  // left
        search(depth + 1, mid + 1, end);    // right
    }
}