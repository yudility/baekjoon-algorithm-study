package BOJ_2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class 괄호제거_한성지 {

    static char[] input;

    static List<int[]> brackets = new ArrayList<>();    // 괄호쌍 위치 저장 ['('인덱스, ')'인덱스]
    static Set<String> result = new TreeSet<>();        // 결과 저장, 자동 정렬
    static boolean[] check;                             // 괄호 제거 여부 판단 배열

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine().toCharArray();   // 수식


        // 괄호 쌍 구하기
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length; i++) {

            if (input[i] == '(') {
                stack.push(i);
            } else if (input[i] == ')') {
                brackets.add(new int[]{stack.pop(), i});
            }
        }

        // check 초기화
        check = new boolean[input.length];

        // 괄호 제거
        comb(0);

        // 출력
        result.forEach(System.out::println);
    }

    static void comb(int depth) {
        if (depth == brackets.size()) {
            boolean b = false;    // 괄호가 1개 이상 제거됐는지 나타냄

            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < input.length; i++) {
                if (!check[i]) {
                    sb.append(input[i]);    // input에서 check가 false인 경우 sb에 추가
                } else {
                    b = true;     // input에서 true를 만나면(제거된 괄호를 만나면) b를 true로 변경 == 제거된 괄호가 있다
                }
            }

            if (b) {  // 최소 1개의 괄호가 제거된 경우 TreeSet에 저장
                result.add(sb.toString());
            }

            return;     // 재귀함수의 현재 호출을 종료하고, 직전 호출로 돌아감
        }

        // 현재 괄호 제거 안함
        comb(depth + 1);

        // 현재 괄호 제거
        int[] pair = brackets.get(depth);   // 삭제한 괄호 위치
        check[pair[0]] = true;              // 해당 괄호가 삭제됐음을 표시
        check[pair[1]] = true;
        comb(depth + 1);              // 해당 괄호가 삭제된 상태로 다시 재귀함수 호출
        check[pair[0]] = false;             // 해당 괄호가 삭제된 모든 경우의 수를 result에 저장한 후 다시 false로 변경
        check[pair[1]] = false;
    }
}
