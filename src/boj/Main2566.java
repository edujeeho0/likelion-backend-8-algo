package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2566
public class Main2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 기본적으로 9 * 9 배열로 고정되어 있다.
        int[][] board = new int[9][];
        // 한줄씩 입력 받아가며
        for (int i = 0; i < 9; i++) {
            String[] row = reader.readLine().split(" ");
            // 한줄의 숫자를 차례데로 넣어준다.
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        // 제일 왼쪽 위의 값을 기본 최댓값으로 상정한다.
        int max = board[0][0];
        // 그 위치를 기록한다.
        int x = 0;
        int y = 0;
        // 모든 줄을 순회하고,
        for (int i = 0; i < 9; i++) {
            // 모든 칸을 순회한다.
            for (int j = 0; j < 9; j++) {
                // 현재의 위치가 기록된 값보다 더 크다.
                if (board[i][j] > max) {
                    // 해당 최댓값을 기록하고
                    max = board[i][j];
                    // x와 y의 위치도 기록해준다.
                    x = j;
                    y = i;
                }
            }
        }

        // 정답을 만들어 준다.
        StringBuilder answerBuilder = new StringBuilder();
        // 최댓값
        answerBuilder.append(max)
                .append('\n')    // 개행
                .append(y + 1)   // 1부터 세니까 + 1
                .append(" ")     // 공백
                .append(x + 1);  // 1부터 세니까 + 1
        // 출력
        System.out.println(answerBuilder);
    }
}
