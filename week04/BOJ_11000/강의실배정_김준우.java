package BOJ_11000;

import java.util.*;

public class 강의실배정_김준우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for (int i = 0; i < n; i++) {
            startTimes[i] = sc.nextInt();
            endTimes[i] = sc.nextInt();
        }

        // 시작 시간과 종료 시간을 각각 정렬
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int roomCount = 0;
        int endIndex = 0;

        // 시작 시간을 하나씩 확인하면서 종료 시간과 비교
        for (int i = 0; i < n; i++) {
            if (startTimes[i] >= endTimes[endIndex]) {
                // 기존 강의실을 재사용 가능하므로 종료 시간 이동
                endIndex++;
            } else {
                // 새 강의실 필요
                roomCount++;
            }
        }

        System.out.println(roomCount);
    }
}
