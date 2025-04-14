package BOJ_20438;

import java.util.Scanner;

public class 출석체크_김준우 {
    static int N, K, Q, M;
    static boolean[] students, sleeping;
    static int[] prefixSum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 학생 수
        K = sc.nextInt(); // 졸고 있는 학생 수
        Q = sc.nextInt(); // 출석 코드를 받을 학생 수
        M = sc.nextInt(); // 구간 개수

        students = new boolean[N + 3];
        sleeping = new boolean[N + 3];
        prefixSum = new int[N + 3];

        for (int i = 0; i < K; i++) {
            int sleep = sc.nextInt();
            sleeping[sleep] = true;
        }

        for (int i = 0; i < Q; i++) {
            int student = sc.nextInt();
            if (sleeping[student]) continue; // 자고 있는 학생은 제외

            for (int j = student; j < N + 3; j += student) { // 본인의 입장 번호의 배수인 학생들에게 코드 보내기
                if (!sleeping[j]) { // 자고 있는 학생은 제외
                    students[j] = true;
                }
            }
        }

        for (int i = 3; i < N + 3; i++) {
            prefixSum[i] = prefixSum[i - 1] + (students[i] ? 0 : 1);
        }

        while (M-- > 0) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(prefixSum[end] - prefixSum[start - 1]);
        }
    }
}
