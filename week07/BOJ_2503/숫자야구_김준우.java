package BOJ_2503;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    int number, strike, ball;

    public Question(int number, int strike, int ball) {
        this.number = number;
        this.strike = strike;
        this.ball = ball;
    }
}

public class 숫자야구_김준우 {
    static int MIN_VALUE = 123;
    static int MAX_VALUE = 987;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Question> questions = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            int number = sc.nextInt();
            int strike = sc.nextInt();
            int ball = sc.nextInt();
            questions.add(new Question(number, strike, ball));
        }

        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            if (valid(i) && isPossible(i, questions)) {
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }

    // 3자리 수는 모두 다른 숫자여야 하고, 0이 포함되면 안된다.
    static boolean valid(int num) {
        String s = String.valueOf(num);
        return s.charAt(0) != s.charAt(1) && s.charAt(1) != s.charAt(2) && s.charAt(0) != s.charAt(2) && !s.contains("0");
    }

    static boolean isPossible(int answer, List<Question> questions) {
        for (Question question : questions) {
            if (!matches(answer, question)) {
                return false;
            }
        }
        return true;
    }

    static boolean matches(int answer, Question question) {
        int strike =0, ball = 0;
        String aStr = String.valueOf(answer);
        String qStr = String.valueOf(question.number);

        for (int i = 0; i < 3; i++) {
            if (aStr.charAt(i) == qStr.charAt(i)) {
                strike++;
            } else if (qStr.contains(String.valueOf(aStr.charAt(i)))) {
                ball++;
            }
        }
        return strike == question.strike && ball == question.ball;

    }
}
