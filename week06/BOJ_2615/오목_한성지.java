package BOJ_2615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 오목_한성지 {

    static int[][] map;     // 오목판

    // 오른쪽, 아래, 오른쪽 아래 대각선, 오른쪽 위 대각선
    static int[] dx = {1, 0, 1, 1};    // x좌표 방향
    static int[] dy = {0, 1, -1, 1};     // y좌표 방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[19][19];

        // 오목판 채우기
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 오목 확인
        // 왼쪽에서 오른쪽으로 검사 - i, j 순서이면 위에서 아래 방향으로 검사하게 됨 -> 가장 첫번째 돌 이외의 돌을 출력할 수 있음
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                // 오목판에 바둑돌이 있을 때 (1 또는 2일 때)
                if (map[i][j] != 0) {
                    // 네가지 방향 검사
                    for (int dir = 0; dir < 4; dir++) {
                        // 현재 바둑돌 좌표
                        int nx = i;
                        int ny = j;
                        int cnt = 1;    // 현재 연속 오목돌 개수

                        while (true) {
                            nx += dx[dir];  // x좌표 이동
                            ny += dy[dir];  // y좌표 이동
                            if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                                if (map[i][j] == map[nx][ny]) { // 연속되는 바둑돌인 경우
                                    cnt++;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                        nx = i;
                        ny = j;

                        // 반대 방향 검사 - 6개 이상인 경우 걸러내기 위함
                        while (true) {
                            nx -= dx[dir];
                            ny -= dy[dir];
                            if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19) {
                                if (map[i][j] == map[nx][ny]) {
                                    cnt++;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        
                        // cnt가 정확히 5일 때 출력
                        if (cnt == 5) {
                            System.out.println(map[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }

        // 그 외 상황일 때는 0 출력
        System.out.println(0);
    }
}