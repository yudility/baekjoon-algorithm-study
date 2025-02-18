package BOJ_21314;

import java.util.Scanner;

public class 민겸수_김준우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        maxNum(input);
        minNum(input);
    }

    private static void minNum(String input) {
        int mCount = 0; // 연속된 M 개수를 카운트
        StringBuilder minNum = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c == 'M') {
                mCount++;
            } else { // 'K'가 등장한 경우
                if (mCount > 0) {
                    minNum.append("1").append("0".repeat(mCount - 1));
                    mCount = 0;
                }
                minNum.append("5");
            }
        }

        // 마지막까지 M이 남아 있다면 처리
        if (mCount > 0) {
            minNum.append("1");
            minNum.append("0".repeat(mCount - 1));
        }

        System.out.println(minNum);
    }

    private static void maxNum(String input) {
        int mCount = 0; // 연속된 M 개수를 카운트
        StringBuilder maxNum = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c == 'M') {
                mCount++;
            } else { // 'K'가 등장한 경우
                maxNum.append("5").append("0".repeat(mCount));
                mCount = 0;
            }
        }

        // 마지막까지 M이 남아 있다면 처리
        if (mCount > 0) {
            maxNum.append("1".repeat(mCount));
        }

        System.out.println(maxNum);
    }
}
