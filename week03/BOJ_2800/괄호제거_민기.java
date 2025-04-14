package BOJ_2800;

import java.util.*;
import java.io.*;

public class 괄호제거_민기 {
    static String expression; // 입력받은 수식을 저장할 문자열
    static TreeSet<String> resultSet = new TreeSet<>(); // 중복을 방지하고 사전순 정렬을 위한 TreeSet 사용
    static List<int[]> pairs = new ArrayList<>(); // 괄호 쌍의 위치를 저장하는 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        expression=br.readLine();

        //괄호를 찾자 앞뒤로 빼는게 좋으니까 deque를 사용하는게 좋을까?
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                stack.push(i); // 여는 괄호의 인덱스를 저장
            } else if (ch == ')') {
                int index = stack.pop(); // 가장 최근의 여는 괄호 위치를 가져옴
                //각쌍의 인덱스를 저장한다
                pairs.add(new int[]{index, i});
            }
        }

        // DFS를 이용한 괄호 제거 조합 탐색
        dfs(0, new boolean[pairs.size()]);

        // TreeSet을 이용하여 사전순 정렬된 결과 출력
        for(String str: resultSet) {
            System.out.println(str);
        }
    }

    //DFS + 백트래킹을 활용하여 괄호를 제거하는 모든 경우의 수를 탐색
    static void dfs(int index, boolean[] removed) {
        // 모든 괄호 쌍을 검사한 경우
        if (index == pairs.size()) {
            // 모든 괄호가 그대로 남아있으면 (즉, 아무 괄호도 제거하지 않은 경우) 저장할 필요 없음
            boolean isAllRemoved = true;
            for (boolean b : removed) {
                // 하나라도 제거한 괄호가 있다면
                if(b){
                    isAllRemoved = false;
                    break;
                }
            }
            // 모든 괄호가 남아있다면 종료
            if(isAllRemoved) return;

            // 괄호를 제거한 새로운 수식을 생성
            StringBuilder sb = new StringBuilder();
            // 특정 인덱스의 괄호를 제거할지 저장하는 배열
            boolean[] toRemove = new boolean[expression.length()];
            for (int i = 0; i < pairs.size(); i++) {
                // 제거해야 하는 괄호라면
                if (removed[i]) {
                    int openidx = pairs.get(i)[0];
                    int closeidx = pairs.get(i)[1];
                    toRemove[openidx] = true;
                    toRemove[closeidx] = true;
                }
            }

            // 제거되지 않은 문자들만 Stringbuilder로 저장
            for (int i = 0; i < expression.length(); i++) {
                if(!toRemove[i]){
                    sb.append(expression.charAt(i));
                }
            }
            resultSet.add(sb.toString());
            return;
        }
        // 현재 괄호를 유지하고 다음 탐색
        removed[index] = false;
        dfs(index + 1, removed);

        // 현재 괄호를 제거하고 다음 탐색
        removed[index] = true;
        dfs(index + 1, removed);
    }
}
