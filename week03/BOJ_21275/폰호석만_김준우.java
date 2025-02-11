package BOJ_21275;

import java.util.Scanner;

public class 폰호석만_김준우 {
    // 문자(Character)를 10진수의 값으로 변환시키는 메서드
    static int charToValue(char ch) {
        if (ch >= '0' && ch <= '9') {
            return ch - '0'; // 숫자는 0 ~ 9까지
        } else if (ch >= 'a' && ch <= 'z') {
            return ch - 'a' + 10; // a부터 z까지는 10 ~ 35까지 -> 총 36개
        }
        return -1;
    }

    // 입력으로 주어진 문자열을 10진수로 변환하는 메서드
    static long convertToDecimal(String str, int base) {
        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            int digit = charToValue(str.charAt(i));
            if (digit >= base) {
                return -1;
            }
            result = result * base + digit; // 진법 변환을 위한 누적 계산 방법
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numA = sc.next();
        String numB = sc.next();

        int maxBase = 36;
        boolean foundSolution = false;
        boolean multipleSolution = false;
        long solutionX = -1;
        long solutionA = -1;
        long solutionB = -1;

        for (int A = 2; A <= maxBase; A++) { // 2진수부터 maxBase 진수까지 완전탐색
            for (int B = 2; B <= maxBase; B++) {
                if (A == B) { // A와 B가 같은 경우는 제외합니다
                    continue;
                }

                long X_from_A = convertToDecimal(numA, A);
                if (X_from_A == -1) continue;

                long X_from_B = convertToDecimal(numB, B);
                if (X_from_B == -1) continue;

                if (X_from_A == X_from_B) {
                    if (foundSolution) { // 이미 해답이 존재한다면??
                        multipleSolution = true; // 다중해 존재
                        break;
                    }

                    foundSolution = true; // 단일해 존재
                    solutionX = X_from_A;
                    solutionA = A;
                    solutionB = B;
                }
            }

            if (multipleSolution) break; // 여러 해가 존재한다면 끝!
        }

        // 각 케이스 별로 출력하기
        if (multipleSolution) {
            System.out.println("Multiple");
        } else if (foundSolution) {
            System.out.println(solutionX + " " + solutionA + " " + solutionB);
        } else {
            System.out.println("Impossible");
        }
    }
}
