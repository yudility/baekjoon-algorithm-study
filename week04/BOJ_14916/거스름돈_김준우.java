package BOJ_14916;

import java.util.Scanner;

public class 거스름돈_김준우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int change = sc.nextInt();
        int count = 0;
        boolean possible = false;
        if (change % 5 == 0) {
            System.out.println(change / 5);
            possible = true;
        } else {
            while (change > 0) {
                change -= 2;
                count++;
                if (change % 5 == 0) {
                    System.out.println(count + change / 5);
                    possible = true;
                    break;
                }
            }
        }
        if (!possible) {
            System.out.println(-1);
        }
    }
}
