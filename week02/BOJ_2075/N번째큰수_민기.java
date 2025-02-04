package BOJ_2075;

import java.io.*;
import java.util.*;

public class N번째큰수_민기 {

    static class Cell {
        int row;
        int col;
        int value;

        Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    public static int findNthLargest(int[][] matrix, int n) {
        PriorityQueue<Cell> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.value, a.value)
        );

        // 마지막 행의 값을 최대 힙에 삽입
        for (int col = 0; col < n; col++) {
            maxHeap.offer(new Cell(n - 1, col, matrix[n - 1][col]));
        }

        int answer = -1;
        for (int i = 0; i < n; i++) {
            Cell top = maxHeap.poll();
            answer = top.value;
            int row = top.row;
            int col = top.col;

            if (row > 0) {
                maxHeap.offer(new Cell(row - 1, col, matrix[row - 1][col]));
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // N 입력 받기

        int[][] matrix = new int[n][n];  // N x N 배열 선언

        // 입력을 BufferedReader로 받아서 배열 채우기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = findNthLargest(matrix, n);
        System.out.println(result);
    }
}
