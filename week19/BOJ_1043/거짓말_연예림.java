package BOJ_1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 거짓말_연예림 {

    static int[] parent; // 상위 노드 기록
    static int KNOW = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사람 수, 파티 수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        // 진실을 아는 사람 수
        int trueCount = Integer.parseInt(st.nextToken());

        // 진실을 아는 사람은 0번에 연결
        for (int i = 0; i < trueCount; i++) {
            int person = Integer.parseInt(st.nextToken());
            union(KNOW, person);
        }

        // 파티 참여 정보
        List<List<Integer>> partyList = new ArrayList<>();

        // 참가자, 참가자 번호
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());

            List<Integer> party = new ArrayList<>();

            for (int j = 0; j < partySize; j++) { // 참가자
                int person = Integer.parseInt(st.nextToken());
                party.add(person);
            }

            // 파티 내 사람들 연결
            for (int j = 0; j < partySize - 1; j++) {
                union(party.get(j), party.get(j+1));
            }

            partyList.add(party);
        }

        int count = 0;
        for (List<Integer> party : partyList) {
            boolean lie = true; // 거짓말을 할 수 있는지

            // 파티 중 한 사람이라도 진실을 알고 있다면 거짓말을 할 수 없음
            for (int person : party) {
                if (find(person) == find(KNOW)) {
                    lie = false;
                    break;
                }
            }
            if (lie) {
                count++;
            }
        }

        System.out.println(count);
    }

    static int find(int x) {
        if (parent[x] != x) { // 자기 자신이 루트가 아니라면
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA < rootB) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
        }
    }
}
