package BOJ_14501;

import java.util.Scanner;

public class 퇴사_김준우 {
    static int n;
    static int maxProfit;
    static int[] t, p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = new int[n + 1];
        p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        simulation(1, 0);
        System.out.println(maxProfit);
    }

    static void simulation(int time, int profit) {
// 퇴사일에 도달하면 maxProfit을 갱신
        if (time ==  n + 1) {
            maxProfit = Math.max(maxProfit, profit);
            return;
        }
// 퇴사일을 지나면 종료
        if (time > n) {
            return;
        }

        if (time + t[time] <= n + 1) {
            simulation(time + t[time], profit + p[time]);
        }

        simulation(time + 1, profit);
    }
}
