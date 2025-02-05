package BOJ_2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 괄호제거_김준우 {
    static Set<String> results = new TreeSet<>(); // 정렬을 위해 TreeSet 사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Integer> stack = new Stack<>();
        List<int[]> bracketPairs = new ArrayList<>();

        // 괄호 위치 짝맞추기
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else if (input.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    bracketPairs.add(new int[]{stack.pop(), i});
                }
            }
        }

        // 모든 괄호 조합에 대해 문자열 생성 -> 비트마스킹 사용(bit-masking)
        int pairCount = bracketPairs.size();
        for (int i = 1; i < (1 << pairCount); i++) { // 1부터 시작 (공집합 제외)
            Set<Integer> removeIndexes = new HashSet<>();
            for (int j = 0; j < pairCount; j++) {
                if ((i & (1 << j)) != 0) {
                    removeIndexes.add(bracketPairs.get(j)[0]); // 여는 괄호
                    removeIndexes.add(bracketPairs.get(j)[1]); // 닫는 괄호
                }
            }
            generateString(input, removeIndexes);
        }

        // 출력
        for (String result : results) {
            System.out.println(result);
        }
    }

    private static void generateString(String input, Set<Integer> removeIndexes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (!removeIndexes.contains(i)) {
                sb.append(input.charAt(i));
            }
        }
        results.add(sb.toString());
    }
}
