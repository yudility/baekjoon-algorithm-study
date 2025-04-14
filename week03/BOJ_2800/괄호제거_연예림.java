package BOJ_2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// https://ilmiodiario.tistory.com/147
// https://loosie.tistory.com/766
public class 괄호제거_연예림 {

    static List<int[]> loc;
    static Set<String> result;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] arr = input.toCharArray();

        // 짝 맞추기 (위치 확인)
        Deque<Integer> stack = new LinkedList<>();

        // 괄호 위치 저장
        loc = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.offer(i);
            } else if (arr[i] == ')') {
                loc.add(new int[]{stack.pollLast(), i});
            }
        }

        result = new TreeSet<>(); // 정렬 저장, 중복제거
        check = new boolean[arr.length];
        comb(0, arr);
        result.forEach(System.out::println);
    }
    
    // 괄호 존재여부 모든 조합 구하기 (보통 조합ㅇ
    static void comb(int depth, char[] str) {
        if (depth == loc.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length; i++) {
                if(!check[i]) { // 괄호가 아닌 문자나 제외된 괄호인 경우
                    sb.append(str[i]);
                }
            }
            if(str.length != sb.length()) {
                result.add(sb.toString());
            }
            return;
        }

        int[] index = loc.get(depth);
        // 해당 괄호를 포함하지 않는 경우 (변경될 부분)
        check[index[0]] = true;
        check[index[1]] = true;
        comb(depth+1, str);
        // 해당 괄호를 포함하는 경우 (원상복귀)
        check[index[0]] = false;
        check[index[1]] = false;
        comb(depth+1, str);
    }
}
