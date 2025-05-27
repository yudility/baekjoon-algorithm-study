package BOJ_22862;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴짝수연속한부분수열L_민기 {

    static int S[];
    static int N,K;
    static int odd_count=0;
    static int max_len=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = new int[N];

        st = new StringTokenizer(br.readLine());

        //수열의 개수를 통해 S배열에 데이터값넣기
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        //최대 길이 구하기 위한 함수
        window();

    }

    static void window() {
        int left=0;
        int right = 0;

        //만약 right포인터가 수열의 끝 그 이상으로 이동했을때
        while (right < N) {
            // 현재 right 포인터가 가리키는 값이 홀수라면, 삭제 대상이므로 odd_count를 증가
            if (S[right] % 2 == 1) {
                odd_count++;
            }

            // 만약 odd_count > K가 되면?
            while (odd_count > K) {
                // 만약 left 포인터를 값이 홀수였다면 odd_count-1 진행 후 left+1
                if (S[left] % 2 == 1) {
                    odd_count--;
                }
                // 그렇지 않고 left 포인터 값이 짝수였다면 그냥 left+1
                left++;
            }

            // 현재 윈도우에서 짝수로만 이루어진 부분 수열의 길이는 전체 길이 - 홀수 개수
            // 이는 K 이하의 홀수는 삭제 가능한 것으로 간주하므로, 짝수들만 유효
            int current_len = right - left + 1 - odd_count;

            // 그 짝수의 개수와 max_len을 비교하여 max_len이 더 작으면 갱신
            max_len = Math.max(max_len, current_len);

            //모든 비교가 끝났다면 다시 오른쪽 포인터 이동
            right++;
        }

        System.out.println(max_len);
    }

}

