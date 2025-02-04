package BOJ_2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.TreeSet;

public class 괄호제거_박유진 {

    //중복을 제외하여 항상 정렬된 형태로 저장하기 위해 treeSet 사용
    static TreeSet<String> resultSet = new TreeSet<>();
    //문자열을 스택에 넣었다 빼기?
    static Stack<Integer> stack = new Stack<>();
    static int[] bracket;
    static boolean[] visited;

    static String str;
    static int cnt = 0;
    static int idx = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        bracket = new int[str.length()];

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                cnt++;
                bracket[i] = idx; // i번째 문자가 '(' 이면 몇번째 괄호인지 적는다.
                stack.push(idx++);
            }else if(str.charAt(i) == ')') {
                bracket[i] = stack.pop(); // i번째 문자가 ')'이면 짝꿍'('괄호와 짝짓기 위하여 짝꿍 괄호가 몇번째 괄호인지 가져온다
            }
        }
        visited = new boolean[cnt+1];

        dfs(1); // 첫번째 괄호부터 시작

        resultSet.remove(str); //모든 경우의 수 중 원본 문자열 제거

        StringBuilder sb = new StringBuilder();
        for(String s : resultSet) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int idx) {
        //문자열 끝까지 다 돌았다면
        if(idx > cnt+1){
            return;
        }
        String s = "";
        for(int i = 0; i<str.length(); i++) {
            // 괄호이고, 방문했던 괄호라면
            if(bracket[i] != 0 && visited[bracket[i]]) {
               continue;
            }else{
                s += str.charAt(i);
            }
        }
        resultSet.add(s);

        //깊이 우선 탐색이므로 다음 경우의 수 완전 탐색
        for(int i = idx; i<= cnt; i++){
            visited[i] = true;
            dfs(i+1);
            visited[i] = false; //원상복구
        }

    }


}
