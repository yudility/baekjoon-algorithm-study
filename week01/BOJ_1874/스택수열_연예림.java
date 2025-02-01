package BOJ_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 스택수열_연예림 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new LinkedList<>();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) { // 입력 받는거
            nums.add(Integer.parseInt(br.readLine()));
        }

        boolean flag = true;
        int next = 0;
        for (int i = 1; i <= n; i++) { // 카운트
            stack.offer(i);
            sb.append("+").append("\n");

            // nums 값이 stack의 peek값보다 작거나 같으면 계속 pop
            while (!stack.isEmpty() && stack.peekLast() >= (int) nums.get(next)) {
                sb.append("-").append("\n");
                if (stack.pollLast() != (int) nums.get(next)) {
                    flag = false;
                    break;
                }
                next++;
            }
            if (!flag) {
                break;
            }
        }

        if (flag && stack.isEmpty() && n == next) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
