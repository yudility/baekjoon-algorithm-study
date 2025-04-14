package BOJ_20364;

import java.util.Scanner;

public class 부동산다툼_김준우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 땅 번호 저장
        int[] lands = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            lands[i] = i;
        }

        // 다른 오리가 땅을 점유했는지 확인용 배열
        boolean[] occupied = new boolean[N + 1];

        // 1번 오리부터 마지막 오리까지 땅 번호 담기
        int[] ducks = new int[M];
        for (int i = 0; i < M; i++) {
            ducks[i] = sc.nextInt();
        }

        // 1번 오리부터 마지막 오리까지 for 문 돌기
        // 부모 노드가 점유되어 있으면 자식 노드는 갈 수 없다
        for (int i = 0; i < ducks.length; i++) {
            int curDuck = ducks[i];
            int occupiedNum = -1; // 처음 마주치는 점유된 땅 번호 구하기 위한 변수
            boolean canGo = true;
            while (curDuck > 0) {
                if (occupied[curDuck]) {  // 자식 노드 -> 부모 노드 방향으로
                    occupiedNum = curDuck;
                    canGo = false;
                    // break -> 이걸 하면 처음 마주친 땅의 번호가 아니라 가장 마지막에 마주친 땅의 번호를 출력한다.
                }
                curDuck /= 2; // 자식 노드 -> 부모 노드 방향으로
            }

            if (canGo) {
                System.out.println(0);
                occupied[ducks[i]] = true; // 해당 땅에 도착했으므로
            } else {
                System.out.println(occupiedNum); // 갈 수 없다면 처음 마주치는 점유된 땅의 번호
            }
        }
    }
}
