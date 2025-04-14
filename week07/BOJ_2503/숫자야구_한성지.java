package BOJ_2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자야구_한성지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 질문 수
        boolean[] check = new boolean[1000];    // 각 경우의 수에 대한 결과 저장

        // 123 ~ 987까지 확인하기 위한 반복문
        for (int i = 123; i < 1000; i++) {
            String str = Integer.toString(i);   // 숫자 String으로 변환

            // 각 자리수가 0일 수 없음
            if (str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') {
                continue;
            }

            // 각 자리수의 숫자가 겹칠 수 없음
            if (str.charAt(0) == str.charAt(1) || str.charAt(1) == str.charAt(2) || str.charAt(2) == str.charAt(0)) {
                continue;
            }

            // 나머지 경우의 수에 대해 true 처리
            check[i] = true;
        }

        // 질문에 따른 경우의 수 처리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int req = Integer.parseInt(st.nextToken()); // 질문한 세자리 수
            int s = Integer.parseInt(st.nextToken());   // 스트라이크 개수
            int b = Integer.parseInt(st.nextToken());   // 볼 개수

            // 예상 가능한 모든 정답 경우의 수 탐색
            for (int ans = 123; ans < 1000; ans++) {
                // 정답 가능성이 있는 수의 경우
                if (check[ans]) {
                    int ns = 0;
                    int nb = 0;

                    // 질문 숫자와 정답 숫자를 비교
                    for (int first = 0; first < 3; first++) {   // 질문 숫자
                        char reqSplit = Integer.toString(req).charAt(first);

                        for (int second = 0; second < 3; second++) {    // 정답 숫자
                            char ansSplit = Integer.toString(ans).charAt(second);

                            if (reqSplit == ansSplit && first == second) {
                                ns++;
                            } else if (reqSplit == ansSplit) {
                                nb++;
                            }
                        }

                        // 스트라이크와 볼 수가 동일한 경우 true 처리
                        if (ns == s && nb == b) {
                            check[ans] = true;
                        } else {
                            check[ans] = false;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 123; i < 1000; i++) {  // true로 체크된 숫자 개수 계산
            if (check[i]) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}